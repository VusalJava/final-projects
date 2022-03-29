package com.amr.project.service.abstracts;


import com.qiwi.billpayments.sdk.model.out.BillResponse;


import java.net.URISyntaxException;


public interface PaymentService {
    public String getKiwiAuthUrl(Long orderId) throws URISyntaxException;
    public void updateOrderStatusValue(BillResponse response);
    void sendPaymentStatusByEmail(BillResponse response);
}
