package com.alibaba.controller;

import com.alibaba.entities.*;
import com.alibaba.service.AccountDAOImpl;
import com.alibaba.service.ClientDAOImpl;
import com.alibaba.service.EmployeeDAOImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountController {
    Account account = new Account();
    SavingsAccount savingsAccount = new SavingsAccount();
    CheckingAccount checkingAccount = new CheckingAccount();

    AccountDAOImpl seracc = new AccountDAOImpl();

    EmployeeController employeeController = new EmployeeController();
    ClientController clientController = new ClientController();

    public void addAccount(){
        clientController.getAllClient();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Code Client");
        int codeC = sc.nextInt();



        employeeController.AllEmployee();
        System.out.println("Enter Matricule Employee");
        int matriculeEmp = sc.nextInt();

        //account_number, balance, creation_date, status
        System.out.println("Enter balance");
        double balance = sc.nextDouble();
        System.out.println("Enter creation date");
        String creationDate = sc.next();

        System.out.println("Enter status : \n" +
                "1 - active\n" +
                "2 - inactive \n" +
                "3 - blocked\n");

        int ch = sc.nextInt();
        String sts = "ACTIVE";
        if (ch == 1){
            System.out.println("actv");
            sts = "ACTIVE";
        } else if (ch == 2) {
            System.out.println("inctv");
            sts = "INACTIVE";
        }else if (ch == 3) {
            System.out.println("blk");
            sts = "BLOCKED";
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate creationDateprs = LocalDate.parse(creationDate, formatter);

        account.setBalance(balance);
        account.setCreationDate(creationDateprs);
        account.setStatus(AccountStatus.valueOf(sts));

        Client client = new Client();  // Initialize the Client object
        client.setCode(codeC);
        account.setClient(client);  // Set the Client object for the account

        Employee employee = new Employee();  // Initialize the Employee object
        employee.setMatricule(matriculeEmp);
        account.setEmployee(employee);


        System.out.println("Enter type account : \n" +
                "1 - Savings Account\n" +
                "2 - Current Account\n");

        int typeAccount = sc.nextInt();
        if (typeAccount == 1){
            System.out.println("Savings");
            System.out.println("Enter interest Rate");
            double interestRate = sc.nextDouble();
            savingsAccount.setBalance(account.getBalance());
            savingsAccount.setCreationDate(account.getCreationDate());
            savingsAccount.setStatus(account.getStatus());
            savingsAccount.setClient(account.getClient());
            savingsAccount.setEmployee(account.getEmployee());

            savingsAccount.setInterestRate(interestRate);
            seracc.createAccountSavinge(savingsAccount);


        } else if (typeAccount == 2) {
            System.out.println("Current");
            System.out.println("Enter overdraft");
            double overdraft = sc.nextDouble();
            checkingAccount.setBalance(account.getBalance());
            checkingAccount.setCreationDate(account.getCreationDate());
            checkingAccount.setStatus(account.getStatus());
            checkingAccount.setClient(account.getClient());
            checkingAccount.setEmployee(account.getEmployee());

            checkingAccount.setOverdraftLimit(overdraft);
            seracc.createAccountChecking(checkingAccount);
        }





    }

}
