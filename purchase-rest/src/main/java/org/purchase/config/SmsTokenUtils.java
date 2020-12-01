package org.purchase.config;

import org.apache.commons.lang3.RandomStringUtils;
import org.purchase.dto.SmsUserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SmsTokenUtils {

    private static final List<SmsUserDTO> userStorages = new ArrayList<>();

    public boolean validateToken(String phone, String token) {
        List<SmsUserDTO> smsUserDTOS = userStorages.stream().filter(user -> user.getToken().equals(token)).collect(Collectors.toList());
        if (smsUserDTOS.size() != 1) {
            return false;
        }

        return smsUserDTOS.get(0).getPhone().equals(phone);
    }

    public String generateToken(String phone) {
        SmsUserDTO smsUserDTO;
        List<SmsUserDTO> smsUserDTOS = userStorages.stream().filter(user -> user.getPhone().equals(phone)).collect(Collectors.toList());
        if (smsUserDTOS.size() == 1) {
            smsUserDTO = smsUserDTOS.get(0);
        } else {
            smsUserDTO = new SmsUserDTO();
            smsUserDTO.setPhone(phone);
        }
        String token = RandomStringUtils.randomNumeric(6);
        smsUserDTO.setToken(token);
        userStorages.add(smsUserDTO);
        return token;
    }
}
