package org.purchase.data.config;

import org.purchase.data.adapter.VoucherCodeRepositoryAdapter;
import org.purchase.data.client.CodeGeneratorClient;
import org.purchase.domain.repository.VoucherCodeRepository;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(PurchaseDataRestProperties.class)
public class DataRestConfiguration {

    @Bean
    VoucherCodeRepository voucherCodeRepository(CodeGeneratorClient codeGeneratorClient) {
        return new VoucherCodeRepositoryAdapter(codeGeneratorClient);
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