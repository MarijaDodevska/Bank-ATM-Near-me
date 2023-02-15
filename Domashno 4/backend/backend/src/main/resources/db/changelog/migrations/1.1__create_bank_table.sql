-- liquibase formatted sql

-- changeset btrajkova:1.1
CREATE TABLE `Bank`
(
    `id`           bigint  NOT NULL AUTO_INCREMENT,
    `x`            decimal NOT NULL,
    `y`            decimal NOT NULL,
    `bank_name`    varchar(32) default NULL,
    `address`      varchar(64) default NULL,
    `phone_number` varchar(64) default NULL,
    PRIMARY KEY (`id`)
)