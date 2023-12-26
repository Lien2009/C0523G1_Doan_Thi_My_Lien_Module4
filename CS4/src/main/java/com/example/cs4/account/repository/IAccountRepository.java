package com.example.cs4.account.repository;

import com.example.cs4.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer>{
    Account findAccountByUserName(String username);
}
