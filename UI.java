package com.TechBee.Classroom;
import java.util.*;

public class UI {
	public static ArrayList<Student> students = new ArrayList<Student>(10);
	
	Boolean addStudent(int uniqueId) {
		
		// go through students and make sure nobody has that student id	
		for(Student student : students) {
			if(student.getStudentId() == uniqueId) {
				return false;
			}
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
	
	Boolean removeStudent(int id) {
		for(Student student : students) {
			if(student.getStudentId() == id) {
				// found student
				// remove
				return students.remove(student);
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		UI ui = new UI();
		Scanner obj = new Scanner(System.in);
		
		Boolean running = true;
		while(running) {
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
					if(students.size() == 10) {
						System.err.println("Classroom is full. Unable to add student.");
						break;
					}
					// Proceed to adding a student
					else {
						System.out.println("Please enter a unique student ID.");
						int studentId = obj.nextInt();
						obj.nextLine(); // skip the newline
						if(ui.addStudent(studentId)) {
							System.out.println("Student successfully added.");
						}
						else{
							System.err.println("Student with id " + studentId + " already exists.");
						}
					}
					break;
				case "r":
					// remove a student
					if(students.isEmpty()) {
						System.err.println("Classroom is empty. Unable to remove student.");
						break;
					}
					else {
						System.out.println("Please enter a unique student ID.");
						int studentId = obj.nextInt();
						obj.nextLine(); // skip the newline
						if(ui.removeStudent(studentId)) {
							System.out.println("Removed student.");
						}
						else{
							System.err.println("Student not found.");
						}
					}
				case "u":
					if(students.isEmpty()) {
						System.err.println("Classroom is empty.");
						break;
					}
					// update a student
					// Remove, then re add the student's info
					System.out.println("Please enter a unique student ID.");
					int studentId = obj.nextInt();
					obj.nextLine(); // skip the newline
					if(ui.removeStudent(studentId)) {
						// add the student again
						ui.addStudent(studentId);
					}
					else{
						System.err.println("Student not found.");
					}
				case "l":
					// list all students
					for(Student student : students) {
						System.out.println("------------------------------------");
						System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
						System.out.println("Phone Number: " + student.getPhoneNumber());
						System.out.println("Social Security: " + student.getSsn());
						System.out.println("GPA: " + student.getGpa());
						System.out.println("ID: " + student.getStudentId());
						System.out.println("Email Address: " + student.getEmailAddress());
					}
					break;
				default:
					break;
			}
		}
		
	}
}
