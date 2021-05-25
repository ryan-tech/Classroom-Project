package com.TechBee.Classroom;
import java.util.*;
public class DAOClass implements DAOInterface{

    List<Student> students;

    public DAOClass() {
        students = new ArrayList<Student>(10);
    }

    public Boolean isUnique(int uniqueId) {
        for(Student student : students) {
            if(student.getStudentId() == uniqueId) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean addStudent(int uniqueId) {
        if(!isUnique(uniqueId)) {
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        long phoneNumber; //10 digits without hyphens
        long ssn; //10 digits without hyphens
        float gpa; // a.bb format
        String emailAddress;

        System.out.println("Enter the student's first name.");
        firstName = scanner.nextLine();
        System.out.println("Enter the student's last name.");
        lastName = scanner.nextLine();
        System.out.println("Enter the student's phone number (10 digits without hyphens).");
        phoneNumber = scanner.nextLong();
        scanner.nextLine(); // get rid of the newline
        System.out.println("Enter the student's social security number (10 digits without hyphens).");
        ssn = scanner.nextLong();
        scanner.nextLine(); // get rid of the newline
        System.out.println("Enter the student's gpa (a.bb format).");
        gpa = scanner.nextFloat();
        scanner.nextLine(); // get rid of the newline
        System.out.println("Enter the student's email address.");
        emailAddress = scanner.nextLine();

        // create the student and add it to the array list
        Student newStudent = new Student(firstName, lastName, phoneNumber, ssn, gpa, uniqueId, emailAddress);
        students.add(newStudent);

        return true;
    }

    @Override
    public Boolean removeStudent(int uniqueId) {
        for(Student student : students) {
            if(student.getStudentId() == uniqueId) {
                // found student
                // remove
                return students.remove(student);
            }
        }
        return false;
    }

    @Override
    public Boolean updateStudent(int uniqueId) {
        if(removeStudent(uniqueId)) {
            return addStudent(uniqueId);
        }
        return false;
    }

    @Override
    public void listStudents() {
        for(Student student : students) {
            System.out.println("------------------------------------");
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Phone Number: " + student.getPhoneNumber());
            System.out.println("Social Security: " + student.getSsn());
            System.out.println("GPA: " + student.getGpa());
            System.out.println("ID: " + student.getStudentId());
            System.out.println("Email Address: " + student.getEmailAddress());
        }
    }
}
