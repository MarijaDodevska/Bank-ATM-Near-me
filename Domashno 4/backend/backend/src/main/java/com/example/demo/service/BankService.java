package com.example.demo.service;

import com.example.demo.entity.Bank;
import com.example.demo.entity.dto.UpsertBankDto;

import java.util.List;

public interface BankService {

    Bank[] getBanks(String search, double lat, double lng);

    String addBank(UpsertBankDto upsertBankDto);

}
