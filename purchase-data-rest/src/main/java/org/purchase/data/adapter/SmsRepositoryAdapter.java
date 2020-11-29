package org.purchase.data.adapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.purchase.data.client.SmsClient;
import org.purchase.domain.repository.SmsRepository;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SmsRepositoryAdapter implements SmsRepository {

    SmsClient smsClient;

    @Override
    public void sendSms(String phone, String body) {
        smsClient.sendSms(phone, body);
    }
}
