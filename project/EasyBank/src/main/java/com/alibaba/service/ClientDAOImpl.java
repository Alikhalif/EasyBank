package com.alibaba.service;

import com.alibaba.connection.DB;
import com.alibaba.dao.ClientDAO;
import com.alibaba.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    private Connection connection = DB.getConnection();
    Client client = new Client();

    @Override
    public void addClient(Client client) {
        try {
            String SQL = "INSERT INTO clients (firstname, lastname, birthDate, phone, address, emp_matricule) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setString(1, client.getFirstName());
            pstmt.setString(2, client.getLastName());
            pstmt.setDate(3, java.sql.Date.valueOf(client.getDateOfBirth()));
            pstmt.setString(4, client.getPhoneNumber());
            pstmt.setString(5, client.getAddress());
            pstmt.setInt(6, client.getEmployee().getMatricule());


            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client getClientByCode(int code) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public void deleteClient(int code) {

    }
}
