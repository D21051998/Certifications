<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home</title>
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
<style>
body {
	background-color: #fcfcfc;
}

td {
	padding-right: 20px;
	padding-bottom: 20px;
	padding-top: 10px;
	text-align: left !important;
	vertical-align: middle;
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
	font-size: 15px;
	font-style: normal;
	font-variant: normal;
	font-weight: bold;
	line-height: 23px;
	text-align: center;
}

th {
	text-align: left;
	vertical-align: middle;
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
	font-size: 17px;
	font-style: italic;
	font-variant: normal;
	font-weight: bold;
	line-height: 23px;
}

h3 {
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
	font-size: 20px;
	font-style: normal;
	font-variant: normal;
	font-weight: bolder;
	line-height: 23px;
}

table {
	overflow: hidden;
	text-overflow: ellipsis;
	word-wrap: break-word;
}

a {
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
	font-size: 17px;
	font-style: normal;
	font-variant: normal;
	font-weight: bold;
	line-height: 23px;
}

.container {
	width: 100%;
}

li.borderless {
	border-bottom: 0 none;
	border-top: none;
}

ul {
	list-style: none;
}

.content:before {
	content: "";
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	z-index: -1;
	display: block;
	background-image: url('../resources/images/DSCN7348.jpg');
	-webkit-filter: brightness(0.8);
	filter: brightness(0.8);
	background-size: cover;
	width: 100%;
	height: 100%;
	-webkit-filter: blur(10px);
	-moz-filter: blur(10px);
	-o-filter: blur(10px);
	-ms-filter: blur(10px);
	filter: blur(10px);
}

.content {
	overflow: visible;
	position: relative;
}

div.transbox {
	margin: 30px;
	background-color: #ffffff;
	border: 0px solid;
	background-color: rgba(255, 255, 255, 0.6);
	width: auto;
	/* For IE8 and earlier */
}

.content p {
	margin: 15px;
	background: rgba(255, 255, 255, 0.3);
	padding: 5px;
	box-shadow: 0 0 5px gray;
}
</style>
</head>
<body>
	<jsp:useBean id="partiImpl" scope="page"
		class="com.certification.impl.ParticipantIMPL"></jsp:useBean>
	<jsp:useBean id="certiImpl" scope="page"
		class="com.certification.impl.CertificateIMPL"></jsp:useBean>
	<jsp:useBean id="eventImpl" scope="page"
		class="com.certification.impl.EventIMPL"></jsp:useBean>
	<c:set scope="page" var="participantID" value="i1"></c:set>
	<c:set scope="page" var="allParticipants"
		value="${partiImpl.getAllParticipant()}"></c:set>

	<c:forEach items="${allParticipants}" var="participant">
		<c:if test="${participant.participantId eq participantID}">
			<c:set scope="page" var="target" value="${participant}"></c:set>
		</c:if>
	</c:forEach>
	<div class="container content">
		<div class="row">
			<div class="col-md-2 transbox">
				<h3>Participant Home</h3>
				<br>
				<h4>Participant Details:</h4>
				<table>
					<tr>
						<td>Name</td>
						<td>${target.name}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td>${target.email}</td>
					</tr>
					<tr>
						<td>Contact</td>
						<td>${target.contact}</td>
					</tr>
					<tr>
						<td>Institution</td>
						<td>${target.institution}</td>
					</tr>
				</table>
			</div>
			<div class="col-md-10 transbox">
				<h4>Certificates Details:</h4>
				<table>
					<tr>
						<th>Event Name</th>
						<th>Rank</th>
						<th>Download</th>
					</tr>
					<c:forEach var="targetCertificate"
						items="${partiImpl.getAllCertificatesByParticipantID(target.participantId)}">
						<tr>
							<td>${eventImpl.getEvent(targetCertificate.eventId).eventName}</td>
							<td><c:if test="${empty targetCertificate.rank}">
									<c:out value="Not Mentioned"></c:out>
								</c:if> <c:if test="${not empty targetCertificate.rank}">
									<c:out value="${targetCertificate.rank}"></c:out>
								</c:if></td>
							<td><c:if test="${targetCertificate.downloadable eq true}">
									<c:url value="../Download" var="download">
										<c:param name="eventID" value="${targetCertificate.eventId}"></c:param>
										<c:param name="participantID" value="${target.participantId}"></c:param>
									</c:url>
									<a target="_blank" class="btn btn-info" href="${download}">Download</a>
								</c:if> <c:if test="${not targetCertificate.downloadable eq true}">
									<a class="btn btn-info">Download</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>