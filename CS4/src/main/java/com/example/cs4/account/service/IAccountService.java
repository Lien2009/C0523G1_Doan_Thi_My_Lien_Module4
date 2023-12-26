package com.example.cs4.account.service;

import com.example.cs4.account.model.Account;

public interface IAccountService {
    boolean save (Account account);
    Account findAccountByUserName(String username);
    Account findAccountById(Integer id);

}
