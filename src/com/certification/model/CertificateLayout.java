/**
 * 
 */
package com.certification.model;

/**
 * @author Deepanshu Jain
 *
 */
public class CertificateLayout {

	private String certificateId;
	private String eventId;
	private String certificateImageLocation;
	private String property1abscissa;
	private String property1ordinate;
	
	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
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
		return "CertificateLayout [certificateId=" + certificateId + ", eventId=" + eventId
				+ ", certificateImageLocation=" + certificateImageLocation + ", property1abscissa=" + property1abscissa
				+ ", property1ordinate=" + property1ordinate + "]";
	}
	
	
	
}
