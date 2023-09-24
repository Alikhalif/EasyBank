package com.alibaba.controller;

import com.alibaba.entities.Client;
import com.alibaba.entities.Employee;
import com.alibaba.service.ClientDAOImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClientController {
    Client client = new Client();
    Employee employee=new Employee();
    ClientDAOImpl serclt = new ClientDAOImpl();
    public void addClient(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter firstname");
        String firstName = sc.next();
        System.out.println("Enter lastname");
        String lastName = sc.next();
        System.out.println("Enter date of birth");
        String dateOfBirth = sc.next();
        System.out.println("Enter email");
        String email = sc.next();
        System.out.println("Enter phone number");
        String phoneNumber = sc.next();
        System.out.println("Enter address");
        String address = sc.next();
        System.out.println("Enter matricule Employee");
        int emp_matrcl = sc.nextInt();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirthpars = LocalDate.parse(dateOfBirth, formatter);

        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setDateOfBirth(dateOfBirthpars);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        client.setAddress(address);

        employee.setMatricule(emp_matrcl);
        client.setEmployee(employee);

        serclt.addClient(client);
    }
}
