package org.purchase.data.mapper;

import org.purchase.data.jpa.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.purchase.domain.entity.Purchase;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS
)
public interface PurchaseDataMapper {
    PurchaseEntity map(Purchase purchase);
    Purchase map(PurchaseEntity purchase);
}
