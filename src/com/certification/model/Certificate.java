package com.certification.model;
/**
 * @author Deepanshu Jain
 *
 */
public class Certificate {

	
	//CertId = timestamp
	private String certiId;
	private String eventId;
	private String studentId;
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
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
		return "Certificate [certiId=" + certiId + ", eventId=" + eventId + ", studentId=" + studentId + ", rank="
				+ rank + ", isDownloadable=" + isDownloadable + "]";
	}
	/**
	 * @param certiId
	 * @param eventId
	 * @param studentId
	 * @param rank
	 * @param isDownloadable
	 */
	public Certificate(Certificate certificate) {
		this.certiId = certificate.certiId;
		this.eventId = certificate.eventId;
		this.studentId = certificate.studentId;
		this.rank = certificate.rank;
		this.isDownloadable = certificate.isDownloadable;
	}
	
}
