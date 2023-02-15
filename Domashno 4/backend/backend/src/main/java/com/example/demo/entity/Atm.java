package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "atm")
@NoArgsConstructor
@AllArgsConstructor
public class Atm implements HasId<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "atm_name")
    private String atmName;

    private double x;

    private double y;
    private String address;

}