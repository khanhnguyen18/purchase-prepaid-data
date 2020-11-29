package org.purchase.rest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.purchase.dto.PurchaseDTO;
import org.purchase.mapper.PurchaseDTOMapper;
import org.purchase.service.PurchaseApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/rest/api/v1/purchases")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PurchaseController {

    PurchaseApplicationService purchaseApplicationService;
    PurchaseDTOMapper purchaseDTOMapper;

    @GetMapping("/voucher-code")

    public PurchaseDTO getVoucherCode(@PathParam("phone") String phone) {
        return purchaseDTOMapper.map(purchaseApplicationService.retrieveVoucherCode(phone));
    }
}
