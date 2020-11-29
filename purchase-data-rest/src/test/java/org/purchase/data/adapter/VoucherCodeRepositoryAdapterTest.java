package org.purchase.data.adapter;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.purchase.data.client.CodeGeneratorClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VoucherCodeRepositoryAdapterTest {

    @InjectMocks
    VoucherCodeRepositoryAdapter voucherCodeRepositoryAdapter;

    @Mock
    CodeGeneratorClient codeGeneratorClient;

    @Test
    void getVoucherCode() {
        // Given
        when(codeGeneratorClient.getVoucherCode()).thenReturn("ABC");
        // Then
        assertThat(voucherCodeRepositoryAdapter.getVoucherCode()).isEqualTo("ABC");
    }
}