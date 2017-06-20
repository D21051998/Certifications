/**
 * 
 */
package com.certification.model;

/**
 * @author Deepanshu Jain
 *
 */
public class Login {
	
	private String username;
	private String password;
	private String role;
	private String base;
	private String status;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", role=" + role + ", base=" + base
				+ ", status=" + status + "]";
	}
	/**
	 * @param username
	 * @param password
	 * @param role
	 * @param base
	 * @param status
	 */
	public Login(Login login) {
		this.username = login.username;
		this.password = login.password;
		this.role = login.role;
		this.base = login.base;
		this.status = login.status;
	}
	
	
	
}
