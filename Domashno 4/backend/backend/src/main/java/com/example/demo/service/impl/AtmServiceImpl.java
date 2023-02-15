package com.example.demo.service.impl;

import com.example.demo.entity.Atm;
import com.example.demo.entity.Bank;
import com.example.demo.entity.dto.UpsertAtmDto;
import com.example.demo.entity.dto.UpsertBankDto;
import com.example.demo.repository.AtmRepository;
import com.example.demo.repository.BankRepository;
import com.example.demo.service.AtmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AtmServiceImpl implements AtmService {
    private final AtmRepository atmRepository;

    @Override
    public Atm[] getAtms(String search, double lat, double lng) {
        Atm[] atmList = atmRepository.findAllByAtmNameContaining(search).toArray(new Atm[0]);
        Arrays.sort(atmList, new AtmServiceImpl.AtmDistanceComparator(lat, lng));
        Atm[] returningAtmList = new Atm[6];
        for (int i = 0; i < 6 && i < atmList.length; i++) {
            returningAtmList[i] = atmList[i];
        }
        return returningAtmList;
    }

    @Override
    public String addAtm(UpsertAtmDto upsertAtmDto) {
        Atm newAtm = new Atm();
        newAtm.setAtmName(upsertAtmDto.getAtmName());
        newAtm.setX(upsertAtmDto.getX());
        newAtm.setY(upsertAtmDto.getY());
        newAtm.setAddress(upsertAtmDto.getAddress());
        atmRepository.save(newAtm);
        return "Atm added";
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

    public static class AtmDistanceComparator implements Comparator<Atm> {
        private final double referenceLat;
        private final double referenceLon;

        public AtmDistanceComparator(double referenceLat, double referenceLon) {
            this.referenceLat = referenceLat;
            this.referenceLon = referenceLon;
        }

        public int compare(Atm atm1, Atm atm2) {
            double dist1 = distance(referenceLat, referenceLon, atm1.getX(), atm1.getY());
            double dist2 = distance(referenceLat, referenceLon, atm2.getX(), atm2.getY());
            return Double.compare(dist1, dist2);
        }
    }
}
