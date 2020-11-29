package org.purchase.domain.repository;

import org.purchase.domain.entity.Purchase;

public interface PurchaseRepository {
    Purchase create(Purchase purchase);
}
