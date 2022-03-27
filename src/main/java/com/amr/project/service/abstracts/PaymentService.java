package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Order;
import com.qiwi.billpayments.sdk.model.out.BillResponse;

import java.math.BigDecimal;
import java.net.URISyntaxException;


public interface PaymentService {
   public String getKiwiAuthUrl(Long orderId) throws URISyntaxException;
}
