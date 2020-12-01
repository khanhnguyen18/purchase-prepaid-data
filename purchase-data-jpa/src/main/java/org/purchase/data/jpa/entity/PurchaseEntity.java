package org.purchase.data.jpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "PURCHASE")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PURCHASE")
    Long id;

    String phone;
    String voucherCode;
}
