package com.example.demo.service;

import com.example.demo.entity.Atm;
import com.example.demo.entity.Bank;
import com.example.demo.entity.dto.UpsertAtmDto;
import com.example.demo.entity.dto.UpsertBankDto;

import java.util.List;

public interface AtmService {
        Atm[] getAtms(String search, double lat, double lng);

        String addAtm(UpsertAtmDto upsertAtmDto);

}
