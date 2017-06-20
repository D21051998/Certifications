package com.certification.constant;

public enum Roles {

	ROLE_ADMIN("ROLE_ADMIN"), ROLE_FACULTY("ROLE_FACULTY"), ROLE_STUDENT("ROLE_STUDENT");

	private final String text;

	private Roles(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

}
