package com.amr.project.webapp.controller;

import com.amr.project.service.abstracts.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.qiwi.billpayments.sdk.client.*;
import com.qiwi.billpayments.sdk.model.*;
import com.qiwi.billpayments.sdk.model.out.*;
import com.qiwi.billpayments.sdk.utils.*;
import com.qiwi.billpayments.sdk.web.*;
import lombok.AllArgsConstructor;
import org.apache.http.impl.client.*;
import org.apache.tomcat.util.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;


@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentRestController {

    private final PaymentService paymentService;

    @GetMapping("/kiwi")
    void getKiwiAuthUrl(HttpServletResponse response) throws URISyntaxException, IOException {

        String authURL =  paymentService.getKiwiAuthUrl(4L);

        response.sendRedirect(authURL);
    }

    @GetMapping("/status")
    String getKiwiOrderStatus()  {
        final String secretKey = "eyJ2ZXJzaW9uIjoiUDJQIiwiZGF0YSI6eyJwYXlpbl9tZXJjaGFudF9z" +
                "aXRlX3VpZCI6InhpaG03eS0wMCIsInVzZXJfaWQiOiI3OTk5MDk1NDcxNSIsInNlY3JldCI6I" +
                "jliZjE2MjhiZTE2ZGMxOTcxYzA5ZThmMzQ2YzgyZWM3MjE3YzQ3OTVlMWM3MjFlYjc1MmE2YjY2ZDI1NGIwM2UifX0=";
        String billId = "4";
        BillPaymentClient client = BillPaymentClientFactory.createCustom(
                secretKey,
                new ApacheWebClient(HttpClients.createDefault())
        );
        BillResponse response = client.getBillInfo(billId);

        return response.getStatus().getValue().getValue();
    }
}
