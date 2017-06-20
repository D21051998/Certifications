package com.certification.model;
/**
 * @author Deepanshu Jain
 *
 */
import java.util.Date;

public class Event {

	private String eventId;
	private String facultyAssigned;
	private Date dateStarted;
	private Date dateEnded;
	private boolean isScrap = false;
	private Date facultyAssignedDate;
	private int noDays;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getFacultyAssigned() {
		return facultyAssigned;
	}

	public void setFacultyAssigned(String facultyAssigned) {
		this.facultyAssigned = facultyAssigned;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Date getDateEnded() {
		return dateEnded;
	}

	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}

	public boolean isScrap() {
		return isScrap;
	}

	public void setScrap(boolean isScrap) {
		this.isScrap = isScrap;
	}

	public Date getFacultyAssignedDate() {
		return facultyAssignedDate;
	}

	public void setFacultyAssignedDate(Date facultyAssignedDate) {
		this.facultyAssignedDate = facultyAssignedDate;
	}

	public int getNoDays() {
		return noDays;
	}

	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", facultyAssigned=" + facultyAssigned + ", dateStarted=" + dateStarted
				+ ", dateEnded=" + dateEnded + ", isScrap=" + isScrap + ", facultyAssignedDate=" + facultyAssignedDate
				+ ", noDays=" + noDays + "]";
	}

	public Event(Event event) {

		this.eventId = event.eventId;
		this.facultyAssigned = event.facultyAssigned;
		this.dateStarted = event.dateStarted;
		this.dateEnded = event.dateEnded;
		this.isScrap = event.isScrap;
		this.facultyAssignedDate = event.facultyAssignedDate;
		this.noDays = event.noDays;
	}

}
