package com.certification.constant;

public class Redirect {
	
	public static String redirect(String role, boolean success){
		String url = "index.jsp";
		if(!success){
			return url;
		}
		
		switch(role){
		case "ROLE_FACULTY": url =  "faculty/faculty_home.jsp";
		break;
		case "ROLE_ADMIN": url =  "admin/admin_home.jsp";
		break;
		case "ROLE_STUDENT": url =  "student/student_home.jsp";
		break;
		default:
		}
		return url;
	}

}
