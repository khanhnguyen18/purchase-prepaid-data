package org.purchase.data.client;

import lombok.AllArgsConstructor;
import org.purchase.data.config.PurchaseDataRestProperties;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class SmsClient {
    RestTemplate restTemplate;
    PurchaseDataRestProperties properties;

    public void sendSms(String phone, String body) {
        System.out.println(String.format("Send sms to phone '%s' with body:'%s'", phone, body));
    }
}
