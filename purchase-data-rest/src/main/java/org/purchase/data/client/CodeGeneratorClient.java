package org.purchase.data.client;

import lombok.AllArgsConstructor;
import org.purchase.data.config.PurchaseDataRestProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
public class CodeGeneratorClient {
    RestTemplate restTemplate;
    PurchaseDataRestProperties properties;

    public String getVoucherCode() {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(properties.getCodeGeneratorUrl() + "/generate-code")
                .build().encode().toUri();

        return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, String.class).getBody();
    }
}
