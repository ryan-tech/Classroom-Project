package com.TechBee.Classroom;

public interface DAOInterface {
    Boolean addStudent(int uniqueId);
    Boolean removeStudent(int uniqueId);
    Boolean updateStudent(int uniqueId);
    void listStudents();
}
