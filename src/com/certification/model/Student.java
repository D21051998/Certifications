package com.certification.model;
/**
 * @author Deepanshu Jain
 *
 */
public class Student {
	
	private String studentID;
	private String name;
	private String email;
	private String contact;
	private String institution;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", email=" + email + ", contact=" + contact
				+ ", institution=" + institution + "]";
	}
	/**
	 * @param studentID
	 * @param name
	 * @param email
	 * @param contact
	 * @param institution
	 */
	public Student(Student student) {
		super();
		this.studentID = student.studentID;
		this.name = student.name;
		this.email =student.email;
		this.contact = student.contact;
		this.institution = student.institution;
	}

	
	
}
