package org.purchase.rest;

import org.purchase.dto.SmsRequestDTO;
import org.purchase.dto.SmsResponseDTO;
import org.purchase.service.SmsApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SmsAuthenticationController {

    @Autowired
    SmsApplicationService smsApplicationService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<SmsResponseDTO> createAuthenticationToken(@RequestBody SmsRequestDTO authenticationRequest) {
        String token = smsApplicationService.generateToken(authenticationRequest.getPhone());
        return ResponseEntity.ok(new SmsResponseDTO(token));
    }
}
