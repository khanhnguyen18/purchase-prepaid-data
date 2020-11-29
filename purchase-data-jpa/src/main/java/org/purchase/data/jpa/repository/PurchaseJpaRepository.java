package org.purchase.data.jpa.repository;

import org.purchase.data.jpa.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseJpaRepository extends JpaRepository<PurchaseEntity, Long> {
    PurchaseEntity getByPhone(Long id);
}
