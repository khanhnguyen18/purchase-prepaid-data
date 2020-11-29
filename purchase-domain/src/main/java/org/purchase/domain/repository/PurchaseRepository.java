package org.purchase.domain.repository;

import org.purchase.domain.entity.Purchase;

import java.util.List;

public interface PurchaseRepository {
    Purchase create(Purchase purchase);
    List<Purchase> getAll(String phone);
}
