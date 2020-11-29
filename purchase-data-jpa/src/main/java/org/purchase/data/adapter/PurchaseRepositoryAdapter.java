package org.purchase.data.adapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.purchase.data.jpa.entity.PurchaseEntity;
import org.purchase.data.jpa.repository.PurchaseJpaRepository;
import org.purchase.data.mapper.PurchaseDataMapper;
import org.purchase.domain.entity.Purchase;
import org.purchase.domain.repository.PurchaseRepository;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PurchaseRepositoryAdapter implements PurchaseRepository {

    PurchaseJpaRepository purchaseJpaRepository;
    PurchaseDataMapper purchaseDataMapper;

    @Override
    public Purchase create(Purchase purchase) {
        PurchaseEntity purchaseEntity = purchaseJpaRepository.save(purchaseDataMapper.map(purchase));
        return purchaseDataMapper.map(purchaseEntity);
    }

    @Override
    public List<Purchase> getAll(String phone) {
        return purchaseDataMapper.mapList(purchaseJpaRepository.getByPhone(phone));
    }
}
