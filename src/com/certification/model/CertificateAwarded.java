package com.certification.model;
/**
 * @author Deepanshu Jain
 *
 */
public class CertificateAwarded {

	
	private String certiId;
	private String eventId;
	private String participantId;
	private String rank;
	private boolean isDownloadable;
	public String getCertiId() {
		return certiId;
	}
	public void setCertiId(String certiId) {
		this.certiId = certiId;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getStudentId() {
		return participantId;
	}
	public void setStudentId(String studentId) {
		this.participantId = studentId;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public boolean isDownloadable() {
		return isDownloadable;
	}
	public void setDownloadable(boolean isDownloadable) {
		this.isDownloadable = isDownloadable;
	}
	@Override
	public String toString() {
		return "Certificate [certiId=" + certiId + ", eventId=" + eventId + ", studentId=" + participantId + ", rank="
				+ rank + ", isDownloadable=" + isDownloadable + "]";
	}

	
}
