package com.alibaba.entities;

import java.util.Date;

public class Account {
    private int accountNumber;
    private double balance;
    private Date creationDate;
    private AccountStatus status;

    public Account(int accountNumber, double balance, Date creationDate, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creationDate = creationDate;
        this.status = status;
    }

    public Account(){

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                ", status=" + status +
                '}';
    }


}
