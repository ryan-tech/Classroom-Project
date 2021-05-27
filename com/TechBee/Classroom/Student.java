package com.TechBee.Classroom;

import java.util.Scanner;

public class Student {
	public Student() {}
	public Student(String firstName, String lastName, long phoneNumber, long ssn, float gpa, int studentId,
			String emailAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.gpa = gpa;
		this.studentId = studentId;
		this.emailAddress = emailAddress;
	}
	private String firstName;
	private String lastName;
	private long phoneNumber; //10 digits without hyphens
	private long ssn; //10 digits without hyphens
	private float gpa; // a.bb format
	private int studentId; // unique
	private String emailAddress;
	private Scanner scanner = new Scanner(System.in);
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName() {
		System.out.println("Enter the student's first name.");
		this.firstName = scanner.nextLine();
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName() {
		System.out.println("Enter the student's last name.");
		this.lastName = scanner.nextLine();
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber() {
		System.out.println("Enter the student's phone number.");
		// handle long and newline
		if(scanner.hasNextLong()) {
			this.phoneNumber = scanner.nextLong();
			scanner.nextLine();
		}


	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn() {
		System.out.println("Enter the student's social security number.");
		// handle long and newline
		if(scanner.hasNextLong()) {
			this.ssn = scanner.nextLong();
			scanner.nextLine();
		}
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa() {
		System.out.println("Enter the student's gpa.");
		// handle float and newline
		if(scanner.hasNextFloat()) {
			this.gpa = scanner.nextFloat();
			scanner.nextLine();
		}
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress() {
		System.out.println("Enter the student's email address.");
		this.emailAddress = scanner.nextLine();
	}
}
