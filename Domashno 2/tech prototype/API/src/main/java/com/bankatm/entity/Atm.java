package com.bankatm.api.entity;

import javax.persistence.*;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "atms")
@NoArgsConstructor
@AllArgsConstructor
public class Atm {

    public static final String SEQ = "atm_sq";

    @Id
    private Long id;

    @Column(name = "atmname")
    private String atmName;

    private String x;

    private String y;

}
