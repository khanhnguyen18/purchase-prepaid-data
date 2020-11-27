package org.purchase.rest;

import lombok.AllArgsConstructor;
import org.purchase.service.PurchaseApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/api/v1/purchases")
@AllArgsConstructor
public class PurchaseController {

    private final PurchaseApplicationService purchaseApplicationService;

    @GetMapping("/voucher-code")
    public String getVoucherCode() {
        return purchaseApplicationService.getVoucherCode();
    }
}
