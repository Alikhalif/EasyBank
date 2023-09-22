package com.alibaba.entities;

import java.util.Date;

public class CheckingAccount extends Account{
    private double overdraftLimit;

    public CheckingAccount(int accountNumber, double balance, Date creationDate, AccountStatus status, double overdraftLimit) {
        super(accountNumber, balance, creationDate, status);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
