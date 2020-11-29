package org.purchase;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = {PurchaseApplication.class})
@AutoConfigureMockMvc
public class PurchaseRestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_voucher_code() throws Exception {
        // Given
        WireMockServer server = new WireMockServer(8081);
        server.stubFor(WireMock.get(urlPathMatching("/generate-code"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withFixedDelay(3000)
                        .withHeader("Content-Type", "text/plain")
                        .withBody("EFBCDF")));
        server.start();
        // When
        mockMvc.perform(get("/rest/api/v1/purchases/voucher-code?phone=0900"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phone").value("0900"))
                .andExpect(jsonPath("$.voucherCode").value("EFBCDF"));
    }

}