package com.certification.model;

public class Event {

	private String eventId;
	private String eventName;
	private String facultyIncharge;
	private String dateStarted;
	private String dateEnded;
	private boolean isScrap = false;
	private int noDays;
	public String getEventId() {
		return eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getFacultyIncharge() {
		return facultyIncharge;
	}
	public void setFacultyIncharge(String facultyIncharge) {
		this.facultyIncharge = facultyIncharge;
	}
	public String getDateStarted() {
		return dateStarted;
	}
	public void setDateStarted(String dateStarted) {
		this.dateStarted = dateStarted;
	}
	public String getDateEnded() {
		return dateEnded;
	}
	public void setDateEnded(String dateEnded) {
		this.dateEnded = dateEnded;
	}
	public boolean isScrap() {
		return isScrap;
	}
	public void setScrap(boolean isScrap) {
		this.isScrap = isScrap;
	}
	public int getNoDays() {
		return noDays;
	}
	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", facultyIncharge=" + facultyIncharge
				+ ", dateStarted=" + dateStarted + ", dateEnded=" + dateEnded + ", isScrap=" + isScrap + ", noDays="
				+ noDays + "]";
	}
	
	

}
