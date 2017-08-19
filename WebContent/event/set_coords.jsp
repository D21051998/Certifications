<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/style/bootstrap.css">
<link rel="stylesheet" href="../resources/style/font-lato.css">
<link rel="stylesheet" href="../resources/style/font-montserrat.css">
<link class="jsbin"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script class="jsbin"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>
<body>

	<jsp:useBean id="eventDao" class="com.certification.impl.EventIMPL"></jsp:useBean>


	<%
		String eventID = request.getParameter("eventID");
		request.setAttribute("event", eventDao.getEvent(eventID));
		//out.println(request.getParameter("eventID"));
	%>
	<div>


		<img onclick="showCoords(event)"  style="width:auto;height:auto;max-width: 100%;"
			src="${pageContext.request.contextPath}/images/0da45a4d300debb4892d48e7eabd0c3a.jpg"
			alt="Image">	

		<form>
			<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="1" id="1" value=""><br></td>
				</tr>
				<tr>
					<td>Data Field:</td>
					<td><input type="text" name="2" id="2"><br></td>
				</tr>
				<tr>
					<td>Data Field:</td>
					<td><input type="text" name="3" id="3"><br></td>
				</tr>
				<tr>
					<td>Reset</td>
					<td><button type="reset" onclick="resetCount()">Reset</button>
					</td>
				</tr>
				 
			</table>
		</form>
	</div>
	<script>
		var count = 1;
		function showCoords(event) {
			var evt = event ? event : window.event;
			var x = evt.pageX;
			var y = evt.pageY;
			var coords = (x) + ", " + y;
			console.log(count);
			document.getElementById(count).value = coords;
			count = parseInt(count, 10) + 1;
		}
		function resetCount() {
			count = 1;
		}
	</script>
</body>
</html>