/**
 * 
 */
package com.certification.model;

/**
 * @author Deepanshu Jain
 *
 */
public class CertificateData {

	private String eventId;
	private String eventName;
	private String facultyIncharge;
	private String dateStarted;
	private String dateEnded;
	private boolean isScrap = false;
	private int noDays;
	private String certificateId;
	private String certificateImageLocation;
	private String property1abscissa;
	private String property1ordinate;
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
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
	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	public String getCertificateImageLocation() {
		return certificateImageLocation;
	}
	public void setCertificateImageLocation(String certificateImageLocation) {
		this.certificateImageLocation = certificateImageLocation;
	}
	public String getProperty1abscissa() {
		return property1abscissa;
	}
	public void setProperty1abscissa(String property1abscissa) {
		this.property1abscissa = property1abscissa;
	}
	public String getProperty1ordinate() {
		return property1ordinate;
	}
	public void setProperty1ordinate(String property1ordinate) {
		this.property1ordinate = property1ordinate;
	}
	@Override
	public String toString() {
		return "CertificateData [eventId=" + eventId + ", eventName=" + eventName + ", facultyIncharge="
				+ facultyIncharge + ", dateStarted=" + dateStarted + ", dateEnded=" + dateEnded + ", isScrap=" + isScrap
				+ ", noDays=" + noDays + ", certificateId=" + certificateId + ", certificateImageLocation="
				+ certificateImageLocation + ", property1abscissa=" + property1abscissa + ", property1ordinate="
				+ property1ordinate + "]";
	}

}
