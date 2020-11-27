package org.purchase.data.adapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.purchase.data.client.CodeGeneratorClient;
import org.purchase.domain.repository.PurchaseRepository;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PurchaseRepositoryAdapter implements PurchaseRepository {

    CodeGeneratorClient codeGeneratorClient;

    @Override
    public String getVoucherCode() {
        return codeGeneratorClient.getVoucherCode();
    }
}
