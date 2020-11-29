package org.purchase;

import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        PurchaseApplication.class
})
@AutoConfigureWireMock()
public class PurchaseApplicationLocal extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(PurchaseApplication.class);
        springApp.setAdditionalProfiles("test");
        springApp.run(args);
    }

    @Bean
    public Options wireMockOptions() {
        final WireMockConfiguration options = WireMockSpring.options();
        options.port(8081);
        return options;
    }
}
