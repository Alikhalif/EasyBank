package com.alibaba.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static Connection connection = null;
    private static final String URL = "jdbc:postgresql://localhost:5432/EasyBank";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1999";


    public static Connection getConnection(){
        if(connection == null){
            try {
                connection =  DriverManager.getConnection(URL, USER, PASSWORD);
                if (connection != null){
                    createEmployeesTable(connection);
                    createClientsTable(connection);
                    createAccountsTable(connection);
                    createSavingsAccountsTable(connection);
                    createCurrentAccountsTable(connection);
                    createOperationsTable(connection);
                    createMissionsTable(connection);
                    createMissionAssignmentsTable(connection);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }


    public static void createEmployeesTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS employees ("
                + "matricule SERIAL PRIMARY KEY,"
                + "firstName VARCHAR(255),"
                + "lastName VARCHAR(255),"
                + "recruitmentDate DATE,"
                + "birthDate DATE,"
                + "email VARCHAR(255),"
                + "phone VARCHAR(255),"
                + "address VARCHAR(255)"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
        }
    }

    public static void createClientsTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS clients ("
                + "code SERIAL PRIMARY KEY,"
                + "firstName VARCHAR(255),"
                + "lastName VARCHAR(255),"
                + "birthDate DATE,"
                + "email VARCHAR(255),"
                + "phone VARCHAR(255),"
                + "address VARCHAR(255)"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
        }
    }

    public static void createAccountsTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts ("
                + "accountNumber SERIAL PRIMARY KEY,"
                + "balance DOUBLE PRECISION,"
                + "creationDate DATE,"
                + "status VARCHAR(255),"
                + "clientCode INT,"
                + "employeeMatricule INT,"
                + "FOREIGN KEY (clientCode) REFERENCES clients(code),"
                + "FOREIGN KEY (employeeMatricule) REFERENCES employees(matricule)"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
        }
    }

    public static void createSavingsAccountsTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS savingsAccounts ("
                + "accountNumber INT PRIMARY KEY,"
                + "interestRate DOUBLE PRECISION,"
                + "FOREIGN KEY (accountNumber) REFERENCES accounts(accountNumber) ON DELETE CASCADE ON UPDATE CASCADE"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
        }
    }

    public static void createCurrentAccountsTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS currentAccounts ("
                + "accountNumber INT PRIMARY KEY,"
                + "overdraft DOUBLE PRECISION,"
                + "FOREIGN KEY (accountNumber) REFERENCES accounts(accountNumber) ON DELETE CASCADE ON UPDATE CASCADE"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
        }
    }

    public static void createOperationsTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS operations ("
                + "operationNumber SERIAL PRIMARY KEY,"
                + "creationDate DATE,"
                + "amount DOUBLE PRECISION,"
                + "type VARCHAR(255),"
                + "accountNumber INT,"
                + "employeeMatricule INT,"
                + "FOREIGN KEY (accountNumber) REFERENCES accounts(accountNumber),"
                + "FOREIGN KEY (employeeMatricule) REFERENCES employees(matricule)"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
        }
    }

    public static void createMissionsTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS missions ("
                + "code SERIAL PRIMARY KEY,"
                + "nom VARCHAR(255),"
                + "description VARCHAR(255)"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
        }
    }

    public static void createMissionAssignmentsTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS missionAssignments ("
                + "debut_date TIMESTAMP,"
                + "end_date TIMESTAMP,"
                + "employee_matricule INT REFERENCES employees(matricule),"
                + "mission_code INT PRIMARY KEY REFERENCES missions(code)"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
        }
    }

}
