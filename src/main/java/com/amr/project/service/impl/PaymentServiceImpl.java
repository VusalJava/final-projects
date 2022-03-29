package com.amr.project.service.impl;

import com.amr.project.model.entity.Order;
import com.amr.project.model.enums.Status;
import com.amr.project.service.abstracts.Mailer;
import com.amr.project.service.abstracts.OrderService;
import com.amr.project.service.abstracts.PaymentService;
import com.qiwi.billpayments.sdk.client.BillPaymentClient;
import com.qiwi.billpayments.sdk.client.BillPaymentClientFactory;
import com.qiwi.billpayments.sdk.model.MoneyAmount;
import com.qiwi.billpayments.sdk.model.in.CreateBillInfo;
import com.qiwi.billpayments.sdk.model.in.Customer;
import com.qiwi.billpayments.sdk.model.out.BillResponse;
import com.qiwi.billpayments.sdk.web.ApacheWebClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.Currency;


@Service
public class PaymentServiceImpl implements PaymentService {

    private OrderService orderService;
    private Mailer mailer;

    public PaymentServiceImpl(OrderService orderService, Mailer mailer) {
        this.orderService = orderService;
        this.mailer = mailer;
    }

    //Посылка писем  об оплате покупателю и продавцу
    public void sendPaymentStatusByEmail(BillResponse response) {
        Order order = orderService.getOrderById(Long.valueOf(response.getBillId()));
        String email = order.getUser().getEmail();
        String subject = "KIWI оплата";
        String text;
        String billId = String.valueOf(order.getId());
        String billTotal = String.valueOf(order.getTotal());
//        Если оплата прошла успешно
        if (response.getStatus().getValue().getValue().equals("PAID")) {
            //письмо покупателю
            text = "Успешно оплачен заказ №" + billId + " на сумму: " + billTotal;
            mailer.sendMail(email, subject, text);
            //письмо продавцу (Непонятно, где в таблице orders или связанной с ней User брать продавца?)
        } else if (response.getStatus().getValue().getValue().equals("REJECTED")) {
            //письмо покупателю
            text = "Отклонена оплата по заказу №" + billId + " на сумму: " + billTotal;
            mailer.sendMail(email, subject, text);
            //письмо продавцу (Непонятно, где в таблице orders или связанной с ней User брать продавца?)
        }
    }

    // Обновление статуса заказа в таблице Orders
    public void updateOrderStatusValue(BillResponse response) {
        Long orderId = Long.valueOf(response.getBillId());
        Order order = orderService.getOrderById(orderId);
        switch (response.getStatus().getValue().getValue()) {
            case "WAITING":
                order.setStatus(Status.WAITING);
                break;
            case "PAID":
                order.setStatus(Status.PAID);
                break;
            case "REJECTED":
                order.setStatus(Status.REJECTED);
                break;
            case "EXPIRED":
                order.setStatus(Status.EXPIRED);
                order.setBuyerName("Aleksandr");
                break;
        }
        orderService.update(order);
    }


    //  Отправка заказа на QIWI Api
    public String getKiwiAuthUrl(Long orderId) throws URISyntaxException {

        final String secretKey = "eyJ2ZXJzaW9uIjoiUDJQIiwiZGF0YSI6eyJwYXlpbl9tZXJjaGFudF9z" +
                "aXRlX3VpZCI6InhpaG03eS0wMCIsInVzZXJfaWQiOiI3OTk5MDk1NDcxNSIsInNlY3JldCI6I" +
                "jliZjE2MjhiZTE2ZGMxOTcxYzA5ZThmMzQ2YzgyZWM3MjE3YzQ3OTVlMWM3MjFlYjc1MmE2Yj" +
                "Y2ZDI1NGIwM2UifX0=";

        Order order = orderService.getOrderById(orderId);

        String userEmail = order.getUser().getEmail();
        String userPhone = order.getBuyerPhone();

        BigDecimal totalOrderPrice = order.getTotal();


        BillPaymentClient client = BillPaymentClientFactory.createCustom(
                secretKey,
                new ApacheWebClient(HttpClients.createDefault())
        );

        CreateBillInfo billInfo = new CreateBillInfo(
                orderId.toString(),
                new MoneyAmount(
                        totalOrderPrice,
                        Currency.getInstance("RUB")
                ),
                "",
                ZonedDateTime.now().plusMinutes(300),
                new Customer(
                        userEmail,
                        orderId.toString(),
                        userPhone
                ),
                "https://MyShop"
        );

        BillResponse response = client.createBill(billInfo);

        //Посылаем email продавцу и покупателю если необходимо
        sendPaymentStatusByEmail(response);

        // Обновляем статус поля status в таблице orders значением , полученным от Kiwi
        updateOrderStatusValue(response);

        return response.getPayUrl();
    }
}
