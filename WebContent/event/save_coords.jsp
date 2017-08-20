<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="certiDao" class="com.certification.impl.CertificateIMPL"></jsp:useBean>
<%
String eventID = request.getParameter("eventID");
System.out.println(request.getParameter("1"));
String[] field1 = request.getParameter("1").split("\\.");
System.out.println(field1[0]+" "+field1[1]);
String[] field2 = request.getParameter("2").split("\\.");
String[] field3 = request.getParameter("3").split("\\.");
if(certiDao.updateCoordinates(field1, eventID)){
	response.sendRedirect("../faculty/manage_events.jsp?set_coords=success");
}else{
	response.sendRedirect("../faculty/manage_events.jsp?set_coords=failed");
}
%>
</body>
</html>