package com.bankatm.api.repository;
import com.bankatm.api.entity.Bank;
import com.bankatm.api.entity.Bank;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BankRepository extends BaseRepository<Bank> {

    List<Bank> findAllByBankNameContaining(String bankName);

}
