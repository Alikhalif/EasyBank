package com.alibaba.service;

import com.alibaba.connection.DB;
import com.alibaba.dao.AccountDAO;
import com.alibaba.entities.Account;
import com.alibaba.entities.CheckingAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AccountDAOImpl implements AccountDAO {

    private Connection connection = DB.getConnection();

    @Override
    public void createAccountChecking(Account account) {
        String addAccountQuery = "INSERT INTO accounts (account_number, balance, creation_date, status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(addAccountQuery)) {
            preparedStatement.setInt(1, account.getAccountNumber());
            preparedStatement.setDouble(2, account.getBalance());
            preparedStatement.setDate(3, new java.sql.Date(account.getCreationDate().getTime()));
            preparedStatement.setString(4, account.getStatus().toString());
            preparedStatement.executeUpdate();


            if (account instanceof CheckingAccount) {
                CheckingAccount checkingAccount = (CheckingAccount) account;
                String addCheckingAccountQuery = "INSERT INTO checking_accounts (account_number, overdraft_limit) VALUES (?, ?)";
                try (PreparedStatement ps = connection.prepareStatement(addCheckingAccountQuery)) {
                    ps.setInt(1, checkingAccount.getAccountNumber());
                    ps.setDouble(2, checkingAccount.getOverdraftLimit());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    // Handle SQLException
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account getAccount(int accountNumber) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(int accountNumber) {

    }

}
