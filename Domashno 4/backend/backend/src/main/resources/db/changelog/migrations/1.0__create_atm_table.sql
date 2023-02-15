-- liquibase formatted sql

-- changeset btrajkova:1.0
CREATE TABLE `Atm`
(
    `id`       bigint  NOT NULL AUTO_INCREMENT,
    `x`        decimal NOT NULL,
    `y`        decimal NOT NULL,
    `atm_name` varchar(32) default NULL,
    `address`  varchar(64) default NULL,
    PRIMARY KEY (`id`)
)