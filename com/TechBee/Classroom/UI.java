package com.TechBee.Classroom;
import java.util.*;

public class UI {

	public static void main(String args[]) {
		DAOClass daoClass = new DAOClass();

		Scanner obj = new Scanner(System.in);

		boolean running = true;
		while(true) {
			System.out.println("Would you like to (a)dd a student, "
					+ "(r)emove a student, (u)pdate a student, (l)ist all students, or (q)uit?");
			String input = obj.nextLine().toLowerCase();
			System.out.println(input);
			if(input.equals("q")) {
				System.out.println("Exiting the program.");
				running = false;
				break;
			}
			switch(input) {
				case "a":
					// Check if the classroom is full
					if(daoClass.students.size() == 10) {
						System.err.println("Classroom is full. Unable to add student.");
						break;
					}
					// Proceed to adding a student
					else {
						System.out.println("Please enter a unique student ID.");
						int studentId = obj.nextInt();
						obj.nextLine(); // skip the newline
						if(daoClass.addStudent(studentId)) {
							System.out.println("Student successfully added.");
						}
						else{
							System.err.println("Student with id " + studentId + " already exists.");
						}
					}
					break;
				case "r":
					// remove a student
					if(daoClass.students.isEmpty()) {
						System.err.println("Classroom is empty. Unable to remove student.");
					}
					else {
						System.out.println("Please enter a unique student ID.");
						int studentId = obj.nextInt();
						obj.nextLine(); // skip the newline
						if(daoClass.removeStudent(studentId)) {
							System.out.println("Removed student.");
						}
						else{
							System.err.println("Student not found.");
						}
					}
					break;
				case "u":
					if(daoClass.students.isEmpty()) {
						System.err.println("Classroom is empty.");
						break;
					}
					// update a student
					// Remove, then re add the student's info
					System.out.println("Please enter a unique student ID.");
					int studentId = obj.nextInt();
					obj.nextLine(); // skip the newline
					if(!daoClass.updateStudent(studentId)) {
						System.err.println("Student not found.");
					}
					break;
				case "l":
					// list all students
					daoClass.listStudents();
					break;
				default:
					break;
			}
		}
		
	}
}
