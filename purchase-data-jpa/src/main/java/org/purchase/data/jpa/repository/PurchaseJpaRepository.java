package org.purchase.data.jpa.repository;

import org.purchase.data.jpa.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseJpaRepository extends JpaRepository<PurchaseEntity, Long> {
    List<PurchaseEntity> getByPhone(String phone);
}
