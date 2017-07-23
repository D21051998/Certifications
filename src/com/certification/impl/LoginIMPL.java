/**
 * 
 */
package com.certification.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;

import com.certification.constant.LoginStatus;
import com.certification.dao.LoginDAO;
import com.certification.database.ConnectionFactory;
import com.certification.model.Login;
import com.certification.constant.BCrypt;

/**
 * @author Deepanshu Jain
 *
 */
public class LoginIMPL implements LoginDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.certification.dao.LoginDAO#validateLogin(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public LoginStatus validateLogin(String username, String password) {
		Login login = getLogin(username);
		System.out.println(login);
		if (login == null) {
			return LoginStatus.NO_SUCH_ACCOUNT_FOUND;
		}

		if (login.getStatus().equals("active")) {
			System.out.println(BCrypt.hashpw(password, login.getSalt()) + " " + login.getPassword());

			if (login.getPassword().equals(BCrypt.hashpw(password, login.getSalt()))) {
				return LoginStatus.SUCCESS;
			} else {
				return LoginStatus.WRONG_PASSWORD;
			}
		} else {
			return LoginStatus.DEACTIVATED;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.certification.dao.LoginDAO#getLogin(java.lang.String)
	 */
	@Override
	public Login getLogin(String username) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps1 = conn.prepareStatement("select * from login where username=?");
			System.out.println(username);
			ps1.setString(1, username);
			ResultSet set = ps1.executeQuery();
			if (set.next()) {
				Login login = new Login();
				login.setUsername(set.getString("username"));
				login.setPassword(set.getString("password"));
				login.setStatus(set.getString("status"));
				login.setRole(set.getString("role"));
				login.setSalt(set.getString("salt"));
				return login;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn);
		}
		// TODO Auto-generated method stub
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.certification.dao.LoginDAO#getAllLogins()
	 */
	@Override
	public List<Login> getAllLogins() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.certification.dao.LoginDAO#saveNewLogin(com.certification.model.
	 * Login)
	 */
	@Override
	public boolean saveNewLogin(Login login) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		System.out.println(login);
		try {
			conn = ConnectionFactory.getConnection();
			ps1 = conn
					.prepareStatement("insert into login (username, password, salt, role, status)  values (?,?,?,?,?)");
			String sall = BCrypt.gensalt();
			ps1.setString(1, login.getUsername());
			ps1.setString(2, BCrypt.hashpw(login.getPassword(), sall));
			ps1.setString(3, sall);
			ps1.setString(4, login.getRole());
			ps1.setString(5, login.getStatus());
			if (ps1.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.certification.dao.LoginDAO#getRoleBySessionID(java.lang.String)
	 */
	@Override
	public String getRoleBySessionID(String sessionID) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps1 = conn.prepareStatement("select role from login where sid=?");
			ps1.setString(1, sessionID);
			ResultSet set = ps1.executeQuery();
			if (set.next()) {
				return set.getString("role");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.certification.dao.LoginDAO#insertSessionID(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean insertSessionID(String id, String sessionID) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps1 = conn.prepareStatement("update login set sid=? where username=?");
			ps1.setString(1, sessionID);
			ps1.setString(2, id);
			if (ps1.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.certification.dao.LoginDAO#getUsernameBySessionID(java.lang.String)
	 */
	@Override
	public String getUsernameBySessionID(String sessionID) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps1 = conn.prepareStatement("select username from login where sid=?");
			ps1.setString(1, sessionID);
			ResultSet set = ps1.executeQuery();
			if (set.next()) {
				return set.getString("username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.certification.dao.LoginDAO#deleteSessionID(java.lang.String)
	 */
	@Override
	public void deleteSessionID(String sessionID) {
		Connection connection = null;
		PreparedStatement p1 = null;
		try {
			connection = ConnectionFactory.getConnection();
			p1 = connection.prepareStatement("update login set sid=? where sid=?");
			p1.setNull(1, Types.VARCHAR);
			p1.setString(2, sessionID);
			if (p1.executeUpdate() == 1) {
			} else {
				System.out.println("Logout Not Complete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
	}

}
