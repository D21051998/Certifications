/**
 * 
 */
package com.certification.dao;

import java.util.List;

import com.certification.model.Event;

/**
 * @author Deepanshu Jain
 *
 */
public interface EventDAO {

	public boolean createEvent(Event event );
	public boolean scrapEvent(String eventId);
	public void editEvent(Event event);
	public Event getEvent(String eventId);
	public List<Event> getAllEvents();
	public String getNewEventId();
	
}
