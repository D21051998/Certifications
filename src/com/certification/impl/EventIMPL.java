/**
 * 
 */
package com.certification.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.certification.dao.EventDAO;
import com.certification.database.ConnectionFactory;
import com.certification.model.Event;

/**
 * @author Deepanshu Jain
 *
 */
public class EventIMPL implements EventDAO {

	/* (non-Javadoc)
	 * @see com.certification.dao.EventDAO#createEvent(com.certification.model.Event)
	 */
	@Override
	public boolean createEvent(Event event) {
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("insert into events (eventId, eventName, eventIncharge,eventDuration,isScarp,dateStarted,dateEnded) values (?,?,?,?,?,?,?)");
			statement.setString(1, event.getEventId());
			statement.setString(2, event.getEventName());
			statement.setString(3, event.getFacultyIncharge());
			statement.setInt(4, event.getNoDays());
			statement.setInt(5, event.isScrap()?1:0);
			statement.setString(6, event.getDateStarted());
			statement.setNull(7,Types.DATE);
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

	public String getNewEventId(){
		Connection connection = null;
		PreparedStatement statement = null;
		String eventId = null;
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select eventId from events");
			ResultSet rs = statement.executeQuery();
			ArrayList<Integer> list = new ArrayList<>();
			if (!rs.next()) {
				eventId = "E00001";
			} else {
				rs.beforeFirst();
				while (rs.next()) {
					String result = rs.getString("eventId");
					list.add(Integer.parseInt(result.substring(1)));
				}
				int[] array = list.stream().mapToInt(i -> i).toArray();
				int sno = getMissing(array, array.length);
				eventId = String.format("E%05d", sno);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(connection);
		}
		
		return eventId;
	}
	
	/* (non-Javadoc)
	 * @see com.certification.dao.EventDAO#scrapEvent(java.lang.String)
	 */
	@Override
	public boolean scrapEvent(String eventId) {
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("update events set isscrap=1 where eventId=?");
			statement.setString(1, eventId);
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

	/* (non-Javadoc)
	 * @see com.certification.dao.EventDAO#editEvent(com.certification.model.Event)
	 */
	@Override
	public void editEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.certification.dao.EventDAO#getEvent(java.lang.String)
	 */
	@Override
	public Event getEvent(String eventId) {
		if(getAllEvents().isEmpty() || eventId.isEmpty()){
			return null;
		}
		for(Event event : getAllEvents()){
			if(event.getEventId().equals(eventId)){
				return event;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.certification.dao.EventDAO#getAllEvents()
	 */
	@Override
	public List<Event> getAllEvents() {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Event> list = new ArrayList<>();
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from events");
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				Event event = new Event();
				event.setEventId(rs.getString("eventId"));
				event.setEventName(rs.getString("eventName"));
				event.setFacultyIncharge(rs.getString("eventIncharge"));
				event.setNoDays(rs.getInt("eventDuration"));
				event.setScrap(rs.getInt("isScarp")==0?false:true);
				event.setDateStarted(rs.getString("dateStarted"));
				event.setDateEnded(rs.getString("dateEnded"));
				list.add(event);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(connection);
		}
		return list;
	}
	
	public int getMissing(int[] a, int n) {
		int i;
		int total;
		total = (n + 1) * (n + 2) / 2;
		for (i = 1; i <= n; i++)
			total -= a[i - 1];
		return total;
	}

}
