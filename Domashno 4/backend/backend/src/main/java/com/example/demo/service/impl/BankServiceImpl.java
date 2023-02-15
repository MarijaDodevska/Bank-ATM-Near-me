package com.example.demo.service.impl;

import com.example.demo.entity.Bank;
import com.example.demo.entity.dto.UpsertBankDto;
import com.example.demo.repository.BankRepository;
import com.example.demo.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Override
    public Bank[] getBanks(String search, double lat, double lng) {
        Bank[] bankList = bankRepository.findAllByBankNameContaining(search).toArray(new Bank[0]);
        Arrays.sort(bankList, new BankDistanceComparator(lat, lng));
        Bank[] returningBankList = new Bank[6];
        for (int i = 0; i < 6 && i < bankList.length; i++) {
            returningBankList[i] = bankList[i];
        }
        return returningBankList;
    }

    @Override
    public String addBank(UpsertBankDto upsertBankDto) {
        Bank newBank = new Bank();
        newBank.setBankName(upsertBankDto.getBankName());
        newBank.setX(upsertBankDto.getX());
        newBank.setY(upsertBankDto.getY());
        newBank.setAddress(upsertBankDto.getAddress());
        newBank.setPhone(upsertBankDto.getPhone());
        bankRepository.save(newBank);
        return "Bank added";
    }

    public static double distance(double lat1,
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

    public static class BankDistanceComparator implements Comparator<Bank> {
        private final double referenceLat;
        private final double referenceLon;

        public BankDistanceComparator(double referenceLat, double referenceLon) {
            this.referenceLat = referenceLat;
            this.referenceLon = referenceLon;
        }

        public int compare(Bank bank1, Bank bank2) {
            double dist1 = distance(referenceLat, referenceLon, bank1.getX(), bank1.getY());
            double dist2 = distance(referenceLat, referenceLon, bank2.getX(), bank2.getY());
            return Double.compare(dist1, dist2);
        }
    }
}
