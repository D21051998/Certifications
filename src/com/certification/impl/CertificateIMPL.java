/**
 * 
 */
package com.certification.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.certification.dao.CertificateDAO;
import com.certification.database.ConnectionFactory;
import com.certification.model.CertificateAwarded;
import com.certification.model.CertificateData;
import com.certification.model.CertificateLayout;

/**
 * @author Deepanshu Jain
 *
 */
public class CertificateIMPL implements CertificateDAO {

	
	public boolean toggleDownload(String eventID){
		Connection connection = null;
		PreparedStatement statement = null;
		ParticipantIMPL impl = new ParticipantIMPL();
		
		try {
			connection = ConnectionFactory.getConnection();
			CertificateAwarded awarded = null;
			for(CertificateAwarded certificateAwarded : impl.getAwardedListByEventID(eventID)){
				if(certificateAwarded.getEventId().toLowerCase().equals(eventID.toLowerCase())){
					awarded = certificateAwarded;
					break;
				}
			}	
			statement = connection.prepareStatement("update certificateAwarded set isDownloadable=? where eventID=?");
			statement.setInt(1, awarded.isDownloadable()?0:1);
			statement.setString(2, eventID);
			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return false;
	}
	
	public boolean saveLayoutDetails(CertificateLayout layout) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(
					"insert into certificatelayouts (certificateId, eventId, certificateImageLocation,property1abscissa,property1ordinate) values (?,?,?,?,?)");
			statement.setString(1, layout.getCertificateId());
			statement.setString(2, layout.getEventId());
			statement.setString(3, layout.getCertificateImageLocation());
			statement.setInt(4, Integer.parseInt(layout.getProperty1abscissa()));
			statement.setInt(5, Integer.parseInt(layout.getProperty1ordinate()));
			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return false;
	}

	public boolean updateCoordinates(String[] str, String eventID) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(
					"update certificatelayouts set property1abscissa=? , property1ordinate=? where eventID=?");
			statement.setInt(1, Integer.parseInt(str[0]));
			statement.setInt(2, Integer.parseInt(str[1]));
			statement.setString(3, eventID);
			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return false;
	}

	public CertificateData getCertificateDataByEventID(String eventID) {
		Connection connection = null;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		System.out.println("IN EVENT:"+eventID);
		if(eventID.isEmpty()){
			return null;
		}
		CertificateData data = new CertificateData();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement1 = connection.prepareStatement("select * from events where eventid=?");
			statement2 = connection.prepareStatement("select * from certificatelayouts where eventid=?");
			statement1.setString(1, eventID);
			statement2.setString(1, eventID);
			ResultSet rs1 = statement1.executeQuery();
			ResultSet rs2 = statement2.executeQuery();
			if (rs1.next()) {
				data.setEventId(rs1.getString("eventId"));
				data.setEventName(rs1.getString("eventName"));
				data.setFacultyIncharge(rs1.getString("eventIncharge"));
				data.setNoDays(rs1.getInt("eventDuration"));
				data.setScrap(rs1.getInt("isScarp")==1?true:false);
				data.setDateStarted(rs1.getString("dateStarted"));
				data.setDateEnded(rs1.getString("dateEnded"));
			}
			if(rs2.next()){
				data.setCertificateId(rs2.getString("certificateId"));
				data.setCertificateImageLocation(rs2.getString("certificateImageLocation"));
				data.setProperty1abscissa(rs2.getString("property1abscissa"));
				data.setProperty1ordinate(rs2.getString("property1ordinate"));
			}
			
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}

		return null;
	}
	
	public String getImageNameByEventID(String eventID){
		Connection connection = null;
		PreparedStatement statement2 = null;
		if(eventID.isEmpty()){
			return null;
		}
		try {
			connection = ConnectionFactory.getConnection();
			statement2 = connection.prepareStatement("select * from certificatelayouts where eventid=?");
			statement2.setString(1, eventID);
			ResultSet rs2 = statement2.executeQuery();
			
			if(rs2.next()){
				return rs2.getString("certificateImageLocation");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return "noimage.jpg";
	}

	public List<CertificateAwarded> getAwardedCertificates(String id) {
		List<CertificateAwarded> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from certificateAwarded where certificateId=?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				CertificateAwarded awarded = new CertificateAwarded();
				awarded.setCertiId(rs.getString("certificateId"));
				awarded.setStudentId(rs.getString("participantId"));
				awarded.setEventId(rs.getString("eventID"));
				awarded.setRank(rs.getString("rank"));
				awarded.setDownloadable(rs.getInt("isDownloadable") == 1 ? true : false);
				list.add(awarded);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return list;
	}

	public boolean checkForCertificate(String eventID) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from certificatelayouts where eventid=?");
			statement.setString(1, eventID);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return false;
	}
	
	public static void main(String[] args) {
		CertificateIMPL impl = new CertificateIMPL();
		CertificateData data = impl.getCertificateDataByEventID("E00001");
		System.out.println(data);
	}

}
