package com.alibaba.dao;

import com.alibaba.entities.Account;
import com.alibaba.entities.CheckingAccount;

public interface AccountDAO {
    void createAccountChecking(Account account);
    Account getAccount(int accountNumber);
    void updateAccount(Account account);
    void deleteAccount(int accountNumber);
}
