<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="impl" class="com.certification.impl.CertificateIMPL"></jsp:useBean>
<%
String eventid = request.getParameter("eventID");
if(impl.toggleDownload(eventid)){
	response.sendRedirect("../faculty/manage_events.jsp?toggle=success");
}else{
	response.sendRedirect("../faculty/manage_events.jsp?toggle=failed");
}
%>
</body>
</html>