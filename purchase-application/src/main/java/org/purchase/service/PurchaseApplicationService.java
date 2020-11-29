package org.purchase.service;

import lombok.AllArgsConstructor;
import org.purchase.domain.entity.Purchase;
import org.purchase.domain.repository.PurchaseRepository;
import org.purchase.domain.repository.VoucherCodeRepository;

import java.util.List;

@AllArgsConstructor
public class PurchaseApplicationService {

    PurchaseRepository purchaseRepository;
    VoucherCodeRepository voucherCodeRepository;

    public Purchase retrieveVoucherCode(String phoneNumber) {
        String voucherCode = voucherCodeRepository.getVoucherCode();

        Purchase purchase = Purchase.builder()
                .phone(phoneNumber)
                .voucherCode(voucherCode).build();

        return purchaseRepository.create(purchase);
    }

    public Purchase getAllVoucherCodes(String phoneNumber) {
        String voucherCode = voucherCodeRepository.getVoucherCode();

        Purchase purchase = Purchase.builder()
                .phone(phoneNumber)
                .voucherCode(voucherCode).build();

        return purchaseRepository.create(purchase);
    }

    public List<Purchase> getAllVouchers(String phoneNumber) {
        return purchaseRepository.getAll(phoneNumber);
    }

}
