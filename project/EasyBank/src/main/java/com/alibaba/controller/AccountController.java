package com.alibaba.controller;

import com.alibaba.entities.Account;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountController {
    Account account = new Account();
    public void addAccount(){
        //account_number, balance, creation_date, status
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter balance");
        double balance = sc.nextDouble();
        System.out.println("Enter creation date");
        String creationDate = sc.next();

        System.out.println("1 - serch by title \n" +
                "2 - search by author \n");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        if (ch == 1){
            System.out.println("serch book by title");
        } else if (ch == 2) {
            System.out.println("serch book by author");

        }

        System.out.println("Enter status");
        String status = sc.next();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirthpars = LocalDate.parse(dateOfBirth, formatter);

        account.setAccountNumber(firstName);
        account.setBalance(lastName);
        account.setCreationDate();
        account.setStatus(dateOfBirthpars);


        serclt.addClient(client);
    }

}
