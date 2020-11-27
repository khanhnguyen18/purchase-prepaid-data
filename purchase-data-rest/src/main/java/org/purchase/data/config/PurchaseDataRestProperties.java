package org.purchase.data.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("org.purchase")
public class PurchaseDataRestProperties {

    private String codeGeneratorUrl;
}
