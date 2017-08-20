/**
 * 
 */
package com.certification.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.certification.dao.StudentDAO;
import com.certification.database.ConnectionFactory;
import com.certification.model.CertificateAwarded;
import com.certification.model.Participant;

/**
 * @author Deepanshu Jain
 *
 */
public class ParticipantIMPL implements StudentDAO {

	
	public List<CertificateAwarded> getAwardedList(String id){
		List<CertificateAwarded> list = new ArrayList<CertificateAwarded>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from certificateAwarded where certificateId=?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
	
		
		return list;
	}
	
	/**
	 * 
	 */
	public List<CertificateAwarded> getAllCertificatesByParticipantID(String id){
		List<CertificateAwarded> awardeds = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from certificateAwarded where participantId=?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				CertificateAwarded awarded = new CertificateAwarded();
				awarded.setCertiId(id);
				awarded.setStudentId(rs.getString("participantId"));
				awarded.setEventId(rs.getString("eventID"));
				awarded.setRank(rs.getString("rank"));
				awarded.setDownloadable(rs.getInt("isDownloadable") == 1 ? true : false);
				awardeds.add(awarded);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return awardeds;
		
	}
	
	public  List<Participant> getAllParticipant() {
		// TODO Auto-generated method stub
		List<Participant> list = new ArrayList<Participant>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from participants");
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				//participantId, name, email, contact, institution
				Participant participant = new Participant();
				participant.setParticipantId(rs.getString("participantId"));
				participant.setName(rs.getString("name"));
				participant.setContact(rs.getString("contact"));
				participant.setEmail(rs.getString("email"));
				participant.setInstitution(rs.getString("institution"));
				list.add(participant);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return list;
	}
	
	public List<CertificateAwarded> getAwardedListByEventID(String id){
		List<CertificateAwarded> list = new ArrayList<CertificateAwarded>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from certificateAwarded where eventID=?");
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				//certificateId, eventId, participantId, rank, isDownloadable
				CertificateAwarded awarded = new CertificateAwarded();
				awarded.setCertiId(rs.getString("certificateId"));
				awarded.setDownloadable(rs.getInt("isDownloadable")==1?true:false);
				awarded.setEventId(id);
				awarded.setRank(rs.getString("rank"));
				awarded.setStudentId(rs.getString("participantId"));
				list.add(awarded);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return list;
	}
	
	
	
	
	public void saveAwardedList(List<String[]> list){
		
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(
					"insert into certificateAwarded (certificateId, eventId, participantId, rank, isDownloadable) values (?,?,?,?,?)");
			for(String[] strings: list){
				statement.setString(1, strings[0]);
				statement.setString(2, strings[1]);
				statement.setString(3, strings[2]);
				statement.setString(4, strings[3]);
				statement.setInt(5, Boolean.parseBoolean(strings[4])?1:0);
				statement.executeUpdate();
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		
		
	}
	
	public boolean saveParticipant(Participant participant) {

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(
					"insert into participants (participantId, name, email, contact, institution) values (?,?,?,?,?)");
			statement.setString(1, participant.getParticipantId());
			statement.setString(2, participant.getName());
			statement.setString(3, participant.getEmail());
			statement.setString(4, participant.getContact());
			statement.setString(5, participant.getInstitution());
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
	
	public boolean ifExistsParticipant(String id){
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from participants where participantId==?");
			statement.setString(1, id);
			if(statement.executeQuery().next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
		return false;
	}

	public void saveParticipants(List<Participant> participants) {
		for (Participant participant : participants) {
			saveParticipant(participant);
		}
	}

}
