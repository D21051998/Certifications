/**
 * 
 */
package com.certification.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.certification.dao.CertificateDAO;
import com.certification.database.ConnectionFactory;
import com.certification.model.CertificateLayout;

/**
 * @author Deepanshu Jain
 *
 */
public class CertificateIMPL implements CertificateDAO {

	public boolean saveLayoutDetails(CertificateLayout layout){
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("insert into certificatelayouts (certificateId, eventId, certificateImageLocation,property1abscissa,property1ordinate) values (?,?,?,?,?)");
			statement.setString(1, layout.getCertificateId());
			statement.setString(2, layout.getEventId());
			statement.setString(3, layout.getCertificateImageLocation());
			statement.setInt(4, Integer.parseInt(layout.getProperty1abscissa()));
			statement.setInt(5, Integer.parseInt(layout.getProperty1ordinate()));
			if(statement.executeUpdate()>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(connection);
		}
		return false;
		
	}
	
}
