package com.TechBee.Classroom;

public class Student {
	
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
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
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
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
