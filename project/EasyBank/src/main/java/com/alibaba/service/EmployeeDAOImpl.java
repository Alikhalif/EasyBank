package com.alibaba.service;

import com.alibaba.connection.DB;
import com.alibaba.dao.EmployeeDAO;
import com.alibaba.entities.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection = DB.getConnection();
    Employee emp = new Employee();

    @Override
    public void addEmployee(Employee employee) {
        try {
            String SQL = "INSERT INTO employees (firstName, lastName, birthDate, email, phone, address, recruitmentDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setDate(3, java.sql.Date.valueOf(employee.getDateOfBirth()));
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getPhoneNumber());
            pstmt.setString(6, employee.getAddress());
            pstmt.setDate(7, java.sql.Date.valueOf(employee.getDateOfRecruitment()));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getEmployeeByMatricule(String matricule) {
        return null;
        // Implement the logic to retrieve an employee by matricule from the database
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try{
            String sql = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
//            firstName, lastName, birthDate, email, phone, address, recruitmentDate
            while (resultSet.next()){
                emp.setFirstName(resultSet.getString("firstName"));
                emp.setLastName(resultSet.getString("lastName"));
                emp.setDateOfBirth(resultSet.getDate("birthDate").toLocalDate());
                emp.setEmail(resultSet.getString("email"));
                emp.setPhoneNumber(resultSet.getString("phone"));
                emp.setAddress(resultSet.getString("address"));
                emp.setDateOfRecruitment(resultSet.getDate("recruitmentDate").toLocalDate());
                employees.add(emp);
            }
            return employees;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
        // Implement the logic to retrieve all employees from the database
    }

    @Override
    public void updateEmployee(Employee employee) {
        // Implement the logic to update an employee in the database
    }

    @Override
    public void deleteEmployee(String matricule) {
        // Implement the logic to delete an employee from the database
    }
}
