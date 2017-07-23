package com.certification.dao;

import java.util.List;

import com.certification.constant.LoginStatus;
import com.certification.model.Login;

/**
 * @author Deepanshu Jain
 *
 */

public interface LoginDAO {

	public LoginStatus validateLogin(String username , String password);
	public Login getLogin(String username);
	public List<Login> getAllLogins();
	public boolean saveNewLogin(Login login);
	public String getRoleBySessionID(String sessionID);
	public boolean insertSessionID(String id, String sessionID);
	public String getUsernameBySessionID(String sessionID);
	public void deleteSessionID(String sessionID);
	
}

