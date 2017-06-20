/**
 * 
 */
package com.certification.model;

/**
 * @author Deepanshu Jain
 *
 */
public class Faculty {
	
	private String facultyId;
	private String name;
	private String email;
	private String contact;
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
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
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", name=" + name + ", email=" + email + ", contact=" + contact + "]";
	}
	/**
	 * @param facultyId
	 * @param name
	 * @param email
	 * @param contact
	 */
	public Faculty(Faculty faculty) {
		this.facultyId = faculty.facultyId;
		this.name = faculty.name;
		this.email = faculty.email;
		this.contact = faculty.contact;
	}

}
