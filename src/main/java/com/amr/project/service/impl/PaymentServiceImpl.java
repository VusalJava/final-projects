package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Order;
import com.amr.project.service.abstracts.*;
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
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private OrderService orderService;


    public PaymentServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    public String getKiwiAuthUrl(Long orderId) throws URISyntaxException {
        final String secretKey = "eyJ2ZXJzaW9uIjoiUDJQIiwiZGF0YSI6eyJwYXlpbl9tZXJjaGFudF9z" +
                "aXRlX3VpZCI6InhpaG03eS0wMCIsInVzZXJfaWQiOiI3OTk5MDk1NDcxNSIsInNlY3JldCI6I" +
                "jliZjE2MjhiZTE2ZGMxOTcxYzA5ZThmMzQ2YzgyZWM3MjE3YzQ3OTVlMWM3MjFlYjc1MmE2YjY2ZDI1NGIwM2UifX0=";

        BigDecimal totalOrderPrice = orderService.getOrderById(orderId).getTotal();


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
                "Тестовый платеж",
                ZonedDateTime.now().plusSeconds(600),
                new Customer(
                        "vladimir789789@gmail.com",
                        orderId.toString(),
                        "79123456789"
                ),
                "http://89.179.107.61:8888/shop"
        );


        BillResponse response = client.createBill(billInfo);
        System.out.println(response);

        return response.getPayUrl();
    }
}
