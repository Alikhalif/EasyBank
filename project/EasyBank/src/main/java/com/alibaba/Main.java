package com.alibaba;
import com.alibaba.connection.DB;
import com.alibaba.controller.AccountController;
import com.alibaba.controller.ClientController;
import com.alibaba.controller.EmployeeController;

import java.sql.Connection;
import java.sql.SQLException;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        DB.getConnection();
        EmployeeController empc = new EmployeeController();
        ClientController cltc = new ClientController();
        AccountController accc = new AccountController();

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
                    "10 - Read book by status Borrowe : \n" +
                    "11 - Search for Book : \n" +
                    "12 - Borrowe Book : \n" +
                    "13 - Return  Book Borrowed : \n" +
                    "14 - Statistics : \n" +
                    "15 - Report : \n" +

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
                    System.out.println("1 - serch by title \n" +
                            "2 - search by author \n");
                    Scanner sc = new Scanner(System.in);
                    int ch = sc.nextInt();
                    if (ch == 1){
                        System.out.println("serch book by title");
                    } else if (ch == 2) {
                        System.out.println("serch book by author");

                    }

                    break;

                case 12 :
                    System.out.println("****************** Borrowe book");
                    break;

                case 13 :
                    System.out.println("****************** Return  Book Borrowed ");
                    break;

                case 14 :
                    System.out.println("****************** Statistics ");

                    break;

                case 15 :
                    break;

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