package com.example.demo.entity.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UpsertBankDto {

    private String bankName;

    private double x;

    private double y;

    private String address;

    private String phone;
}