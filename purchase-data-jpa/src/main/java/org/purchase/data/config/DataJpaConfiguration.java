package org.purchase.data.config;

import org.purchase.data.adapter.PurchaseRepositoryAdapter;
import org.purchase.data.jpa.entity.PurchaseEntity;
import org.purchase.data.jpa.repository.PurchaseJpaRepository;
import org.purchase.data.mapper.PurchaseDataMapper;
import org.purchase.domain.repository.PurchaseRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = PurchaseEntity.class)
@EnableJpaRepositories(basePackageClasses = PurchaseJpaRepository.class)
public class DataJpaConfiguration {

    @Bean
    public PurchaseRepository purchaseRepositoryAdapter(
            PurchaseJpaRepository purchaseJpaRepository,
            PurchaseDataMapper purchaseDataMapper) {
        return new PurchaseRepositoryAdapter(purchaseJpaRepository, purchaseDataMapper);
    }

}
