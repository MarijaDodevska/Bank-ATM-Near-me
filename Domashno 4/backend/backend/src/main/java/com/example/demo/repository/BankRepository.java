package com.example.demo.repository;


import com.example.demo.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends BaseRepository<Bank> {

    List<Bank> findAllByBankNameContaining(String bankName);

}
