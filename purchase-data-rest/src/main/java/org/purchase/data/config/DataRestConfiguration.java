package org.purchase.data.config;

import org.purchase.data.adapter.SmsRepositoryAdapter;
import org.purchase.data.adapter.VoucherCodeRepositoryAdapter;
import org.purchase.data.client.CodeGeneratorClient;
import org.purchase.data.client.SmsClient;
import org.purchase.domain.repository.SmsRepository;
import org.purchase.domain.repository.VoucherCodeRepository;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

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
    SmsClient smsClient(RestTemplate restTemplate, PurchaseDataRestProperties properties) {
        return new SmsClient(restTemplate, properties);
    }

    @Bean
    SmsRepository smsRepository(SmsClient smsClient) {
        return new SmsRepositoryAdapter(smsClient);
    }

    @Bean
    public RestTemplate restTemplate(
            RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(10))
                .setReadTimeout(Duration.ofSeconds(10))
                .build();
    }

}
