package com.TechBee.Classroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MySQLDAO implements MySQLDAOInterface {

    private Connection conn;

    MySQLDAO() throws SQLException, ClassNotFoundException {
        // create the connection to the database
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String url = "jdbc:mysql://classroomdatabase.cxhvbueeyork.us-west-1.rds.amazonaws.com:3306/classroom";
        final String username = "master";
        final String password = "password";
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("MySQL Database connection successful.");
        // check if table classroom exists
        DatabaseMetaData md = conn.getMetaData();
        ResultSet rs = md.getTables(null, null, "classroom", null);
        if(!rs.next()) {
            // create the table
            String query = "CREATE TABLE classroom (" +
                    "firstName varchar(255)," +
                    "lastName varchar(255)," +
                    "phoneNumber int," +
                    "ssn int," +
                    "gpa float," +
                    "studentId int," +
                    "emailAddress varchar(255)" +
                    ");";

            Statement sqlCode = conn.createStatement();
            sqlCode.executeUpdate(query);
        }
        else{
            System.out.println("classroom table found. Skipping table creation.");
        }
    }

/*
* 	this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		thinewStudent.gpa = gpa;
		this.studentId = studentId;
		this.emailAddress = emailAddress;
* */

    public Boolean addStudent(int uniqueId) throws SQLException {
        // if not unique then return false
        if(!isUniqueId(uniqueId)) {
            return false;
        }

        // Create new student with the unique id
        Student newStudent = new Student();
        newStudent.setFirstName();
        newStudent.setLastName();
        newStudent.setPhoneNumber();
        newStudent.setSsn();
        newStudent.setGpa();
        newStudent.setStudentId(uniqueId);
        newStudent.setEmailAddress();

        // create update
        String query = "INSERT INTO classroom " +
            "VALUES (\"" +
            newStudent.getFirstName() + "\", \"" +
            newStudent.getLastName() + "\", " +
            newStudent.getPhoneNumber() + ", " +
            newStudent.getSsn() + ", " +
            newStudent.getGpa() + ", " +
            newStudent.getStudentId() + ", \"" +
            newStudent.getEmailAddress() +
            "\");";
        System.out.println(query);
        Statement sqlCode = conn.createStatement();
        sqlCode.executeUpdate(query);
        return true;
    }
    public Boolean removeStudent(int uniqueId) throws SQLException {
        // if it is unique, that means a student doesn't exist with that id already
        if(isUniqueId(uniqueId)) {
            return false;
        }
        String query = "DELETE FROM classroom " +
                "WHERE studentId = " + uniqueId + ";"
                ;

        Statement sqlCode = conn.createStatement();
        sqlCode.executeUpdate(query);
        return true;
    }
    public Boolean updateStudent(int uniqueId) throws SQLException {
        // if is unique, then that means a student with the id doesn't exist in the db
        if(isUniqueId(uniqueId)) {
            return false;
        }

        // Create new student with the unique id
        Student newStudent = new Student();
        newStudent.setFirstName();
        newStudent.setLastName();
        newStudent.setPhoneNumber();
        newStudent.setSsn();
        newStudent.setGpa();
        newStudent.setStudentId(uniqueId);
        newStudent.setEmailAddress();

        // create update
        String query = "UPDATE classroom " +
                "SET " +
                "firstName = \"" + newStudent.getFirstName() + "\"," +
                "lastName = \"" + newStudent.getLastName() + "\"," +
                "phoneNumber = " + newStudent.getPhoneNumber() + ", " +
                "ssn = " + newStudent.getSsn() + ", " +
                "gpa = " + newStudent.getGpa() + ", " +
                "studentId = " + newStudent.getStudentId() + ", " +
                "emailAddress = \"" + newStudent.getEmailAddress() + "\" " +
                "WHERE studentId = " + newStudent.getStudentId() + ";";
        System.out.println(query);
        Statement sqlCode = conn.createStatement();
        sqlCode.executeUpdate(query);
        return true;
    }


    public void listStudents() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM classroom";
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        // Iterate through the data in the result set and display it.
        while (rs.next()) {
            //Print one row
            for(int i = 1 ; i <= columnsNumber; i++){

                System.out.print(rsmd.getColumnName(i) + ": " + rs.getString(i) + " "); //Print one element of a row
            }
            System.out.println();//Move to the next line to print the next row.
        }
    }

    public Boolean isUniqueId(int id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(*) FROM classroom WHERE studentId = " + id;
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        return rs.getInt("count(*)") == 0;
        // returns true/false depending on if a row was returned with a matching id
    }

    public int numStudents() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(*) FROM classroom";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        return rs.getInt("count(*)"); // returns number of rows
    }
}
