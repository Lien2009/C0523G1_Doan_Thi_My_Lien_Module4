package com.example.cs4.account.service;

import com.example.cs4.account.model.Account;
import com.example.cs4.account.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public boolean save(Account account) {
        try {
            iAccountRepository.save(account);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Account findAccountByUserName(String username) {
        return iAccountRepository.findAccountByUserName(username);
    }

    @Override
    public Account findAccountById(Integer id) {
        return iAccountRepository.findById(id).get();
    }
}
