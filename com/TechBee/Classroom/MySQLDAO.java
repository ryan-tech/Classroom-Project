package com.TechBee.Classroom;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

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
            "VALUES (" +
            newStudent.getFirstName() +
            newStudent.getLastName() +
            newStudent.getPhoneNumber() +
            newStudent.getSsn() +
            newStudent.getGpa() +
            newStudent.getStudentId() +
            newStudent.getEmailAddress() +
            ");";

        Statement sqlCode = conn.createStatement();
        sqlCode.executeUpdate(query);
        return true;
    }
    public Boolean removeStudent(int uniqueId) throws SQLException {
        String query = "DELETE FROM classroom " +
                "WHERE id=" +
                uniqueId +
                ");"
                ;

        Statement sqlCode = conn.createStatement();
        sqlCode.executeQuery(query);
        return true;
    }
    public Boolean updateStudent(Student s){
        return true;
    }
    public void listStudents()
    {

    }

    public Boolean isUniqueId(int id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(*) FROM classroom WHERE id = " + id;
        ResultSet rs = stmt.executeQuery(sql);
        return !rs.last(); // returns true/false depending on if a row was returned with a matching id
    }

    public int numStudents(int id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(*) FROM classroom";
        ResultSet rs = stmt.executeQuery(sql);
        return rs.last() ? rs.getRow() : 0; // returns number of rows
    }
}
