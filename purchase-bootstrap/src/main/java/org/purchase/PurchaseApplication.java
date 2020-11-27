package org.purchase;

import org.purchase.config.RestConfiguration;
import org.purchase.data.config.DataRestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        RestConfiguration.class,
        DataRestConfiguration.class,
})
public class PurchaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurchaseApplication.class, args);
    }

}
