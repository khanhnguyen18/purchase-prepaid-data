package org.purchase.config;

import org.purchase.domain.repository.PurchaseRepository;
import org.purchase.service.PurchaseApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceConfiguration {

    @Bean
    PurchaseApplicationService purchaseApplicationService(PurchaseRepository purchaseRepository) {
        return new PurchaseApplicationService(purchaseRepository);
    }

}
