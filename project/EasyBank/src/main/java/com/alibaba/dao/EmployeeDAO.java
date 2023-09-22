package com.alibaba.dao;

import com.alibaba.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getEmployeeByMatricule(String matricule);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(String matricule);
}
