package com.example.demo.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "bank")
@AllArgsConstructor
@NoArgsConstructor
public class Bank implements HasId<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank_name")
    private String bankName;

    private double x;

    private double y;

    private String address;
    @Column(name = "phone_number")
    private String phone;
}
