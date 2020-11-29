package org.purchase.it;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.purchase.PurchaseApplication;
import org.purchase.PurchaseApplicationLocal;
import org.purchase.domain.entity.Purchase;
import org.purchase.service.PurchaseApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(classes = {PurchaseApplication.class})
public class PurchaseApplicationServiceIT {

    @MockBean
    PurchaseApplicationLocal purchaseApplicationLocal;

    @Autowired
    private PurchaseApplicationService purchaseApplicationService;

    @Test
    public void get_voucher_code() {
        // Given
        WireMockServer server = new WireMockServer(8081);
        server.stubFor(get(urlPathMatching("/generate-code"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/plain")
                        .withBody("EFBCDF")));
        server.start();
        // When
        Purchase purchase = purchaseApplicationService.retrieveVoucherCode("090909");
        // Then
        assertThat(purchase.getVoucherCode()).isEqualTo("EFBCDF");
        server.stop();
    }

}