package com.example.demo.controller;

import com.example.demo.entity.Atm;
import com.example.demo.entity.Bank;
import com.example.demo.entity.dto.UpsertAtmDto;
import com.example.demo.entity.dto.UpsertBankDto;
import com.example.demo.service.AtmService;
import com.example.demo.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/atm")
public class AtmController {

    private final AtmService atmService;

    @GetMapping("/all")
    public Atm[] getAtms(@RequestParam String search, @RequestParam double lat, @RequestParam double lng){
        return atmService.getAtms(search, lat, lng);
    }

    @PostMapping("/add")
    public String saveAtm(@RequestBody UpsertAtmDto upsertAtmDto){
        return atmService.addAtm(upsertAtmDto);
    }

}
