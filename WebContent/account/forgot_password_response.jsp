<%@page import="java.sql.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.UUID"%>
<%@page import="java.net.InetAddress"%>
<%@page import="org.apache.commons.net.ntp.TimeInfo"%>
<%@page import="org.apache.commons.net.ntp.NTPUDPClient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset New Password</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
.container {
	max-width: 700px;
	position: relative;
	top: 50%;
}

body {
	background-color: #ffa830;
	background-image: url("../resources/images/DSCN7348.jpg");
}

a {
	color: #000000;
}
input{border-style:none;}
</style>

</style>

</head>
<body>
	
	<%
	/*
	String token = request.getParameter("token");
		if (token.isEmpty()) {
			return;
		}
		Object[] data = dao.forgotResponse(token);
		if(null==data){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Request was closed earlier..');");
			out.println("location='../index.jsp';");
			out.println("</script>");
			return;
		}
		Timestamp date =(Timestamp)data[1];
		System.out.println("DATA"+data[0].toString()+" "+data[1].toString());
		String TIME_SERVER = "time-a.nist.gov";
		NTPUDPClient timeClient = new NTPUDPClient();
		InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
		TimeInfo timeInfo = timeClient.getTime(inetAddress);
		long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
		long duration = returnTime - date.getTime();
		System.out.println(data.length);
		if (data.length != 0) {
			if (duration <= 86400000 && duration > 0) {*/
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-6" align="center">
				<h3>
					<strong>The NorthCap University</strong>
				</h3>
				<p>Sector-23A, Gurugram</p>
				<h4>
					<strong>Publication Module</strong>
				</h4>
			</div>
			<div class="col-md-6 form-group" align="center">

				<form method="POST" action="../ResetPassword">
					<table>
						
						<tr>
							<td><label for="password">Enter New Password</label></td>
							<input type="hidden" name="id" value='<c:out value="<%//token%>"/>'>
						</tr>
						<tr>
							<td><input type="text" name="password" id="password"></td>
						</tr>
						<tr>
							<td><label for="password_again">Enter New Password Again</label></td>
						</tr>
						<tr>
							<td><input type="text" name="password_again" id="password_again"></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td>
								<button class="form-control" type="submit">Submit</button>
							</td>
						</tr>
					</table>

				</form>
			</div>
		</div>
	</div>
	<% /*
		} else {
				UUID uuid = UUID.randomUUID();
				String newID = uuid.toString();
				String url = "http://localhost:8080/internship/accounts/reset_password_response.jsp?token=" + newID;
				String message = "Forgot Password? \n Here is a link to reset your password:" + url
						+ "\nIf password is not requested by you, please contact administrator.";
				String subject = "Requested to change password!";
				String username = data[0].toString();
				//String email = dao.getEmailByUsername(username);
				//boolean ifRefreshed = dao.reForgotRequest(newID, username, new Timestamp(returnTime));
				System.out.println("FROM JSP");
				//EmailService.sendEmail("NCU: Forgot Password", message, email);
				out.println("<script type=\"text/javascript\">");
				out.println("alert('The link has now expired. We have sent you another reset link.');");
				out.println("location='../index.jsp';");
				out.println("</script>");
				return;
			}

		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid Data Found!');");
			out.println("location='../index.jsp';");
			out.println("</script>");

		}*/
	%>

</body>
</html>