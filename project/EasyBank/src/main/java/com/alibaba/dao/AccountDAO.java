package com.alibaba.dao;

import com.alibaba.entities.Account;

public interface AccountDAO {
    void createAccount(Account account);
    Account getAccount(int accountNumber);
    void updateAccount(Account account);
    void deleteAccount(int accountNumber);
}
