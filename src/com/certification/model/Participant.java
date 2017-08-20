package com.certification.model;

/**
 * @author Deepanshu Jain
 *
 * @param participantId
 * @param name
 * @param email
 * @param contact
 * @param institution
 */
public class Participant {

	private String participantId;
	private String name;
	private String email;
	private String contact;
	private String institution;

	public String getParticipantId() {
		return participantId;
	}

	public void setParticipantId(String participantId) {
		
		this.participantId = participantId;
	}

	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", name=" + name + ", email=" + email + ", contact="
				+ contact + ", institution=" + institution + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}


}
