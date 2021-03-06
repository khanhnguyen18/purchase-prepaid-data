--------------------------------------------------------
--  DDL for Table PURCHASE
--------------------------------------------------------
CREATE TABLE PURCHASE
(
    "ID" NUMBER(12,0) NOT NULL,
    "PHONE" VARCHAR2(40 CHAR),
    "VOUCHER_CODE" VARCHAR2(40 CHAR)
);

ALTER TABLE "PURCHASE" ADD CONSTRAINT "PK_PURCHASE" PRIMARY KEY ("ID");

CREATE SEQUENCE SEQ_PURCHASE MINVALUE 1 MAXVALUE 999999999999999 INCREMENT BY 1 CACHE 100;
