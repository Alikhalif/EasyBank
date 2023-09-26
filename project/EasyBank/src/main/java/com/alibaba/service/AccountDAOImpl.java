package com.alibaba.service;

import com.alibaba.connection.DB;
import com.alibaba.dao.AccountDAO;
import com.alibaba.entities.Account;
import com.alibaba.entities.CheckingAccount;
import com.alibaba.entities.SavingsAccount;

import java.sql.*;


public class AccountDAOImpl implements AccountDAO {

    private Connection connection = DB.getConnection();

    @Override
    public void createAccountChecking(Account account) {
        String addAccountQuery = "INSERT INTO accounts (balance, creationDate, status, clientCode, employeeMatricule) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(addAccountQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setDate(2, java.sql.Date.valueOf(account.getCreationDate()));
            preparedStatement.setString(3, account.getStatus().toString());
            preparedStatement.setInt(4, account.getClient().getCode());
            preparedStatement.setInt(5, account.getEmployee().getMatricule());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            int accountNumber = -1;
            if (generatedKeys.next()) {
                accountNumber = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve auto-generated account number.");
            }


            if (account instanceof CheckingAccount) {
                CheckingAccount checkingAccount = (CheckingAccount) account;
                String addCheckingAccountQuery = "INSERT INTO currentAccounts (accountNumber, overdraft_limit) VALUES (?, ?)";
                try (PreparedStatement ps = connection.prepareStatement(addCheckingAccountQuery)) {
                    ps.setInt(1, accountNumber);
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
    public void createAccountSavinge(Account account) {
        String addAccountQuery = "INSERT INTO accounts (balance, creationDate, status, clientCode, employeeMatricule) VALUES ( ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(addAccountQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setDate(2, java.sql.Date.valueOf(account.getCreationDate()));
            preparedStatement.setString(3, account.getStatus().toString());
            preparedStatement.setInt(4, account.getClient().getCode());
            preparedStatement.setInt(5, account.getEmployee().getMatricule());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            int accountNumber = -1;
            if (generatedKeys.next()) {
                accountNumber = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve auto-generated account number.");
            }

            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                String SQL = "INSERT INTO savingsAccounts (accountNumber, interestRate) VALUES (?, ?)";
                try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                    ps.setInt(1, accountNumber);
                    ps.setDouble(2, savingsAccount.getInterestRate());
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
