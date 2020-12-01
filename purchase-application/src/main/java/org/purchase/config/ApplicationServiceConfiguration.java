package org.purchase.config;

import org.purchase.domain.repository.PurchaseRepository;
import org.purchase.domain.repository.SmsRepository;
import org.purchase.domain.repository.VoucherCodeRepository;
import org.purchase.service.PurchaseApplicationService;
import org.purchase.service.SmsApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceConfiguration {

    @Bean
    PurchaseApplicationService purchaseApplicationService(
            PurchaseRepository purchaseRepository,
            VoucherCodeRepository voucherCodeRepository) {
        return new PurchaseApplicationService(purchaseRepository, voucherCodeRepository);
    }

    @Bean
    SmsApplicationService smsApplicationService(SmsRepository smsRepository){
        return new SmsApplicationService(smsRepository);
    }

}
