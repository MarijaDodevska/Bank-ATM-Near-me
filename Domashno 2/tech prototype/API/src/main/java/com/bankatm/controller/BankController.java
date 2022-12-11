package com.bankatm.api.controller;

import com.bankatm.api.entity.Bank;
import com.bankatm.api.entity.Dto.UpsertBankDto;
import com.bankatm.api.service.BankServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bank")
public class BankController {

    private final BankServiceImpl bankService;

    @GetMapping("/all")
    public List<Bank> getBanks(@RequestParam String search, @RequestParam String lat, @RequestParam String lng){
        return bankService.getBanks(search, lat, lng);
    }

    @PostMapping("/add")
    public String saveBank(@RequestBody UpsertBankDto upsertBankDro){
        return bankService.addBank(upsertBankDro);
    }

}
