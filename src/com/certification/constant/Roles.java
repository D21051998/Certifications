package com.certification.constant;

public enum Roles {

	ROLE_ADMIN(Messages.getString("Roles.0")), ROLE_FACULTY(Messages.getString("Roles.1")), ROLE_STUDENT(Messages.getString("Roles.2")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	private final String text;

	private Roles(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

}
