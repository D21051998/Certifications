package com.certification.database;

import java.sql.Connection;
import java.sql.Statement;

public class Initiate {
	
	
	public Initiate(){

		Statement stmt;
		Connection conn = null;
	    try{
	    	conn = ConnectionFactory.getConnection();
	    	stmt = conn.createStatement();
	    	
	    	String users = "create table if not exists login("
	    			+ "username varchar(200),"
	    			+ "password varchar(200),"
	    			+ "sessionId varchar(200) unique,"
	    			+ "base varchar(200),"
	    			+ "status int,"
	    			+ "primary key(username)"
	    			+ ");";
	    	stmt.executeUpdate(users);
	    	
	    	String eventTable = "create table if not exists events("
	    			+ "eventId varchar(200),"
	    			+ "eventName varchar(200),"
	    			+ "eventIncharge varchar(200),"
	    			+ "eventDuration int,"
	    			+ "isScrap int,"
	    			+ "dateStarted date,"
	    			+ "dateEnded date,"
	    			+ "primary key (eventId)"
	    			+ ");";
	    	stmt.executeUpdate(eventTable);
	    	
	    	String certificateLayoutTable = "create table if not exists certificateLayouts("
	    			+ "certificateId varchar(200),"
	    			+ "eventId varchar(200),"
	    			+ "certificateImageLocation varchar(500),"
	    			+ "property1abscissa int,"
	    			+ "property1ordinate int,"
	    			+ "primary key (certificateId),"
	    			+ "foreign key (eventId) references events(eventId)"
	    			+ ");";
	    	stmt.executeUpdate(certificateLayoutTable);
	    	
	    	String participants = "create table if not exists participants("
	    			+ "participantId varchar(200),"
	    			+ "name varchar(200),"
	    			+ "email varchar(200),"
	    			+ "contact varchar(200),"
	    			+ "institution varchar(200),"
	    			+ "primary key (participantId)"
	    			+ ");";
	    	stmt.executeUpdate(participants);
	    	
	    	String certificateAwarded = "create table if not exists certificateAwarded("
	    			+ "certificateId varchar(200),"
	    			+ "eventId varchar(200),"
	    			+ "participantId varchar(200),"
	    			+ "rank varchar(200),"
	    			+ "isDownloadable int,"
	    			+ "primary key (certificateId, eventId, participantId),"
	    			+ "foreign key (certificateId) references certificateLayouts(certificateId),"
	    			+ "foreign key (eventId) references events(eventId),"
	    			+ "foreign key (participantId) references participants(participantId)"
	    			+ ");";
	    	stmt.executeUpdate(certificateAwarded);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally {
			ConnectionFactory.close(conn);
			stmt=null;
		}	
	}
	public static void main(String[] args) {
		new Initiate();
	}
}
