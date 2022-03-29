package com.amr.project.webapp.controller;

import com.amr.project.service.abstracts.PaymentService;
import com.qiwi.billpayments.sdk.model.out.BillResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;


@RestController
@AllArgsConstructor
@RequestMapping("/payment/kiwi")
public class PaymentRestController {

    private final PaymentService paymentService;

//  User инициирует оплату с Kiwi, метод получает c front id user-а, как результат редиректит user-а на полученный от Kiwi URL для оплаты
    @PostMapping("")
    void getKiwiAuthUrl(HttpServletResponse response,@RequestBody Long id) throws IOException, URISyntaxException {

        String authURL = paymentService.getKiwiAuthUrl(id);

        response.sendRedirect(authURL);
    }


    //  Слушает уведомления от Kiwi по статусам заказов, и инициирует обновление статуса заказа в таблице orders
    @PostMapping("/status")
    void getKiwiOrderStatus(@RequestBody BillResponse response) {

        paymentService.updateOrderStatusValue(response);
        paymentService.sendPaymentStatusByEmail(response);
    }
}
