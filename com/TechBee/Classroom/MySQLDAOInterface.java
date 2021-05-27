package com.TechBee.Classroom;

import java.sql.SQLException;

public interface MySQLDAOInterface {
    Boolean addStudent(int uniqueId) throws SQLException;
    Boolean removeStudent(int uniqueId) throws SQLException;
    Boolean updateStudent(int uniqueId) throws SQLException;
    void listStudents() throws SQLException;
}
