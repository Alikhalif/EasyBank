package com.alibaba.controller;

import com.alibaba.entities.Account;
import com.alibaba.entities.Employee;
import com.alibaba.entities.Operation;
import com.alibaba.entities.OperationStatus;
import com.alibaba.service.OperationDAOImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OperationController {
    Operation operation = new Operation();
    Account account = new Account();
    Employee employee = new Employee();
    OperationDAOImpl operationDAO = new OperationDAOImpl();
    AccountController accC = new AccountController();
    public void addOperation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount");
        Double amount = sc.nextDouble();

        System.out.println("Enter type operation");
        System.out.println("Enter your choice :\n" +
                "1 - VERSEMENT\n" +
                "2 - RETRAIT \n");
        int choice = sc.nextInt();
        if (choice == 1){
            operation.setOperationStatus(OperationStatus.VERSEMENT);
        } else if (choice == 2) {
            operation.setOperationStatus(OperationStatus.RETRAIT);
        }else {
            System.out.println("Enter number correct");
        }

        System.out.println("Enter number account");
        int numberAcc = sc.nextInt();

        System.out.println("Enter matricule employee");
        int matriculeEmp = sc.nextInt();



        LocalDate DateNow = LocalDate.now();

        operation.setCreationDate(DateNow);
        operation.setAmount(amount);

        account.setAccountNumber(numberAcc);
        operation.setAccount(account);

        employee.setMatricule(matriculeEmp);
        operation.setEmployee(employee);

        if (operation.getOperationStatus().toString() == "VERSEMENT"){
            if (accC.checkOperation(operation)){
                operationDAO.createOperation(operation);
            }
        }else {
            if (accC.retraitOperation(operation)){
                operationDAO.createOperation(operation);
            }
        }



    }



}
