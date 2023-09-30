package com.alibaba.service;

import com.alibaba.connection.DB;
import com.alibaba.entities.Operation;
import com.alibaba.entities.OperationStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperationDAOImpl {
    private Connection connection = DB.getConnection();

    public void createOperation(Operation operation){
        try{
            String SQL = "INSERT INTO operations (creationDate, amount, type, accountNumber, employeeMatricule) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setDate(1, java.sql.Date.valueOf(operation.getCreationDate()));
            pstmt.setDouble(2, operation.getAmount());
            pstmt.setString(3, operation.getOperationStatus().toString());
            pstmt.setInt(4, operation.getEmployee().getMatricule());
            pstmt.setInt(5, operation.getAccount().getAccountNumber());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
