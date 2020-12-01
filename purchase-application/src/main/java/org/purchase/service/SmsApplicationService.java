package org.purchase.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.RandomStringUtils;
import org.purchase.domain.repository.SmsRepository;
import org.purchase.vo.SmsUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SmsApplicationService {

    SmsRepository smsRepository;

    private static final List<SmsUser> userStorage = new ArrayList<>();

    public boolean validateToken(String phone, String token) {
        List<SmsUser> smsUserDTOS = userStorage.stream().filter(user -> user.getToken().equals(token)).collect(Collectors.toList());
        if (smsUserDTOS.size() != 1) {
            return false;
        }

        return smsUserDTOS.get(0).getPhone().equals(phone);
    }

    public String generateToken(String phone) {
        SmsUser smsUser;
        List<SmsUser> smsUserDTOS = userStorage.stream().filter(user -> user.getPhone().equals(phone)).collect(Collectors.toList());
        if (smsUserDTOS.size() == 1) {
            smsUser = smsUserDTOS.get(0);
        } else {
            smsUser = new SmsUser();
            smsUser.setPhone(phone);
        }
        String token = RandomStringUtils.randomNumeric(6);
        smsUser.setToken(token);
        userStorage.add(smsUser);

        smsRepository.sendSms(phone, token);
        return token;
    }

}
