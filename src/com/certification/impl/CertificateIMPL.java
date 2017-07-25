/**
 * 
 */
package com.certification.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;import java.util.ArrayList;
import java.util.List;

import com.certification.dao.CertificateDAO;
import com.certification.database.ConnectionFactory;
import com.certification.model.CertificateAwarded;
import com.certification.model.CertificateLayout;

import oracle.net.aso.s;

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
	
	
	
	public List<CertificateAwarded> getAwardedCertificates(String id){
		List<CertificateAwarded> list= new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from certificateAwarded where certificateId=?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				CertificateAwarded awarded = new CertificateAwarded();
				awarded.setCertiId(id);
				awarded.setStudentId(rs.getString("participantId"));
				awarded.setEventId(rs.getString("eventID"));
				awarded.setRank(rs.getString("rank"));
				awarded.setDownloadable(rs.getInt("isDownloadable")==1?true:false);
				list.add(awarded);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(connection);
		}
		return list;
	}
	
	public boolean checkForCertificate(String eventID){
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from certificatelayouts where eventid=?");
			statement.setString(1, eventID);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
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
