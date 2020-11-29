package org.purchase.domain.repository;

public interface SmsRepository {
    void sendSms(String phone, String body);
}
