package org.purchase.service;

import lombok.AllArgsConstructor;
import org.purchase.domain.entity.Purchase;
import org.purchase.domain.repository.PurchaseRepository;

@AllArgsConstructor
public class PurchaseApplicationService {

    PurchaseRepository purchaseRepository;

    public String getVoucherCode() {
        return purchaseRepository.getVoucherCode();
    }

}
