package com.alibaba.entities;

import java.util.Date;

public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(int accountNumber, double balance, Date creationDate, AccountStatus status, double interestRate) {
        super(accountNumber, balance, creationDate, status);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}
