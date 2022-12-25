package com.example.demo.service.impl;

import com.example.demo.entity.Bank;
import com.example.demo.entity.dto.UpsertBankDto;
import com.example.demo.repository.BankRepository;
import com.example.demo.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Override
    public List<Bank> getBanks(String search, String lat, String lng) {
        List<Bank> bankList = bankRepository.findAllByBankNameContaining(search);
//        List<Bank> returningBankList = new ArrayList<>(6);
//        returningBankList.add(bankList.get(0));
//        for (int x = 0; x < bankList.size(); x++) {
//            for (int y = 0; y < returningBankList.size(); y++){
//                double bankLat = Double.parseDouble(returningBankList.get(y).getX());
//                double bankLng = Double.parseDouble(returningBankList.get(y).getY());
//                double bankDistance = distance(bankLat, Double.parseDouble(lat), bankLng, Double.parseDouble(lng));
//                if (bankDistance <)
//            }
//        }
        return bankList;
    }

    @Override
    public String addBank(UpsertBankDto upsertBankDto) {
        Bank newBank = new Bank();
        newBank.setBankName(upsertBankDto.getBankName());
        newBank.setX(upsertBankDto.getX());
        newBank.setY(upsertBankDto.getY());
        bankRepository.save(newBank);
        return "Bank added";
    }

    public double distance(double lat1,
                           double lat2, double lon1,
                           double lon2) {


        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));


        double r = 6371;


        return (c * r);
    }
}
