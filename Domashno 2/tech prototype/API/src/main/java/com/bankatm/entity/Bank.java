package com.bankatm.api.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "banks")
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    public static final String SEQ = "bank_sq";

    @Id
    private Long id;

    @Column(name = "bankname")
    private String bankName;

    private String x;

    private String y;
}
