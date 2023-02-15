package com.example.demo.repository;

import com.example.demo.entity.Atm;
import com.example.demo.entity.Bank;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends BaseRepository<Atm> {
    List<Atm> findAllByAtmNameContaining(String atmName);
}
