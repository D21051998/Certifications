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
	private String salt;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", role=" + role + ", base=" + salt
				+ ", status=" + status + "]";
	}
	/**
	 * @param username
	 * @param password
	 * @param role
	 * @param salt
	 * @param status
	 */
	public Login(Login login) {
		this.username = login.username;
		this.password = login.password;
		this.role = login.role;
		this.salt = login.salt;
		this.status = login.status;
	}
	/**
	 * 
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
