package org.purchase.mapper;

import org.mapstruct.Mapper;
import org.purchase.domain.entity.Purchase;
import org.purchase.dto.PurchaseDTO;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS
)
public interface PurchaseDTOMapper {
    PurchaseDTO map(Purchase purchase);

    List<PurchaseDTO> mapList(List<Purchase> purchase);
}
