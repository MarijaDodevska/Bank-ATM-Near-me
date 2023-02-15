package com.example.demo.controller;

import com.example.demo.entity.Bank;
import com.example.demo.entity.dto.UpsertBankDto;
import com.example.demo.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bank")
public class BankController {

    private final BankService bankService;

    @GetMapping("/all")
    public Bank[] getBanks(@RequestParam String search, @RequestParam double lat, @RequestParam double lng){
        return bankService.getBanks(search, lat, lng);
    }

    @PostMapping("/add")
    public String saveBank(@RequestBody UpsertBankDto upsertBankDto){
        return bankService.addBank(upsertBankDto);
    }

}
