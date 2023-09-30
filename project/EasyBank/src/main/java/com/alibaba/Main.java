package com.alibaba;
import com.alibaba.connection.DB;
import com.alibaba.controller.AccountController;
import com.alibaba.controller.ClientController;
import com.alibaba.controller.EmployeeController;
import com.alibaba.controller.OperationController;

import java.sql.Connection;
import java.sql.SQLException;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        DB.getConnection();
        EmployeeController empc = new EmployeeController();
        ClientController cltc = new ClientController();
        AccountController accc = new AccountController();
        OperationController opc = new OperationController();

        int choice;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("******** welcome to EasyBank app ********\n" +

                    "1  - Add Employee : \n" +
                    "2  - Read List Employee : \n" +
                    "3  - Update Employee : \n" +
                    "4  - Delete Employee : \n" +

                    "5  - Add Client : \n" +
                    "6  - Read List Clients : \n" +
                    "7  - Delete Client : \n" +
                    "8  - Update  Client : \n" +
                    "9  - Search Client by Code : \n" +

                    "10 - Add Account : \n" +
                    "11 - Read List Accounts : \n" +
                    "12 - Delete Account : \n" +
                    "13 - Update Account : \n" +

                    "14 - Update Status Account : \n" +
                    "15 - Search for account by code client : \n" +

                    "0 - exit.\n\n" +
                    "==> ");

            choice = scanner.nextInt();

            switch (choice){
                case 1 :
                    System.out.println("Add Employee");
                    empc.addEmployee();
                    break;

                case 2 :
                    System.out.println("read Employees");
                    empc.AllEmployee();
                    break;

                case 3 :
                    System.out.println("Update Employee");
                    empc.updateEmployee();
                    break;

                case 4 :
                    System.out.println("****************** delete Employee");
                    empc.deleteEmployee();
                    break;

                case 5 :
                    System.out.println("****************** Add Client");
                    cltc.addClient();
                    break;

                case 6 :
                    System.out.println("****************** Read All Clients");
                    cltc.getAllClient();
                    break;

                case 7 :
                    System.out.println("****************** delete Client");
                    cltc.deleteClient();
                    break;

                case 8 :
                    System.out.println("****************** update Client");
                    cltc.updateEmployee();
                    break;

                case 9 :
                    System.out.println("****************** Search client by code");
                    cltc.getClientByCode();
                    break;

                case 10 :
                    System.out.println("****************** Add Account");
                    accc.addAccount();
                    break;

                case 11 :
                    System.out.println("****************** Read All Accounts");
                    accc.AllAccount();
                    break;

                case 12 :
                    System.out.println("****************** Delete Account");
                    accc.deleteAccount();
                    break;

                case 13 :
                    System.out.println("****************** Update Account");

                    break;

                case 14 :
                    System.out.println("****************** Update Status Account ");
                    accc.updateStatusAccount();
                    break;

                case 15 :
                    System.out.println("***************** Search for account by cient code");
                    accc.searchByClientCode();
                    break;

                case 16 :
                    System.out.println("***************** Select accounts by Status");
                    accc.AllAccountByStatus();
                    break;

                case 17 :
                    System.out.println("***************** Select accounts by date creation");
                    accc.getAccountByDatecreation();
                    break;

                case 18 :
                    System.out.println("***************** Add operation");
                    opc.addOperation();
                    break;

//                case 19 :
//                    System.out.println("***************** Add operation");
//                    accc.getAccountByDatecreation();
//                    break;

                case 0:
                    System.out.println("Good by");
                    break;

                default:
                    System.out.println("Enter valid choice !");

            }

//            scanner.close();
        }while (choice != 0);
    }
}