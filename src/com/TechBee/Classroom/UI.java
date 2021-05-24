package com.TechBee.Classroom;
import java.util.*;

public class UI {
	public ArrayList<Student> students = new ArrayList<Student>(10);
	
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
					if(ui.students.size() == 10) {
						System.out.println("Classroom is full. Unable to add student");
						break;
					}
					// Proceed to adding a student
					else {
						System.out.println("Please enter a unique student ID.");
						int studentId = obj.nextInt();
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
				case "u":
					// update a student
				case "l":
					// list all students
					System.out.println("First name | Last Name | Phone | SSN | GPA | ID | Email Address");
					for(Student student : ui.students) {
						System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getPhoneNumber() + " " + student.getSsn() + " " + student.getGpa() + " " + student.getStudentId() + " " + student.getEmailAddress());
					}
					break;
				default:
					break;
			}
		}
		
	}
}
