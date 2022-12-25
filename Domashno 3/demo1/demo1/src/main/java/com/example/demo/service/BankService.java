package com.example.demo.service;

import com.example.demo.entity.Bank;
import com.example.demo.entity.dto.UpsertBankDto;

import java.util.List;

public interface BankService {

    List<Bank> getBanks(String search, String lat, String lng);

    String addBank(UpsertBankDto upsertBankDto);

}
