package org.purchase.data.config;

import org.purchase.data.adapter.PurchaseRepositoryAdapter;
import org.purchase.data.client.CodeGeneratorClient;
import org.purchase.domain.repository.PurchaseRepository;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(PurchaseDataRestProperties.class)
public class DataRestConfiguration {

    @Bean
    PurchaseRepository purchaseRepository(CodeGeneratorClient codeGeneratorClient) {
        return new PurchaseRepositoryAdapter(codeGeneratorClient);
    }

    @Bean
    CodeGeneratorClient codeGeneratorClient(RestTemplate restTemplate, PurchaseDataRestProperties properties) {
        return new CodeGeneratorClient(restTemplate, properties);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
