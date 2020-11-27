package org.purchase;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.purchase.service.PurchaseApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = {PurchaseApplication.class})
public class PurchaseApplicationServiceIT {

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
        String code = purchaseApplicationService.getVoucherCode();
        // Then
        assertThat(code).isEqualTo("EFBCDF");
        server.stop();
    }

}