package com.bankatm.api.service;

import com.bankatm.api.entity.Bank;
import com.bankatm.api.entity.Dto.UpsertBankDto;

import java.util.List;

public interface BankService {

    List<Bank> getBanks(String search, String lat, String lng);

    String addBank(UpsertBankDto upsertBankDto);

}
