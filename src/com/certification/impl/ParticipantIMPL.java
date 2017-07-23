/**
 * 
 */
package com.certification.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.certification.dao.StudentDAO;
import com.certification.database.ConnectionFactory;
import com.certification.model.Participant;

/**
 * @author Deepanshu Jain
 *
 */
public class ParticipantIMPL implements StudentDAO {
	
	
	public boolean saveParticipant(Participant participant){
		
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("insert into certificatelayouts (participantId, name, email, contact, institution) values (?,?,?,?,?)");
			statement.setString(1, participant.getParticipantId());
			statement.setString(2, participant.getName());
			statement.setString(3, participant.getEmail());
			statement.setString(4, participant.getContact());
			statement.setString(5, participant.getInstitution());
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
	
public void saveParticipants(List<Participant> participants){
		for(Participant participant:participants){
			saveParticipant(participant);
		}
	}
	

}
