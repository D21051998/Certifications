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
<style>
body {
	background-color: #fcfcfc;
}

td {
	vertical-align: middle;
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
	font-size: 15px;
	font-style: normal;
	font-variant: normal;
	font-weight: bold;
	line-height: 23px;
	padding: 10px;
}

th {
	text-align: center;
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
	<div class="container content">
		<div class="row">
			<div class="col-md-12 transbox">
				<h3>Enter Event Details</h3>
				<form action="../SaveNewEvent" method="post">
					<table>
						<tr>
							<td>Event Name</td>
							<td><input type="text" name='eventName' class="form-control"/></td>
						</tr>
						<tr>
							<td>Event Duration</td>
							<td><input type="text" name='eventDuration' class="form-control" /></td>
						</tr>
						<tr>
							<td>Faculty In-charge</td>
							<td><input type="text" name='eventIncharge' class="form-control" /></td>
						</tr>
						<tr>
							<td>Date Started</td>
							<td><input type="date" name="dateStarted" class="form-control" id="theDate">
							</td>
						</tr>
						<tr>
							<td>
								<button type="reset" class="btn btn-danger">Reset</button>
							</td>
							<td>
								<button type="submit" class="btn btn-success">Submit</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var date = new Date();

			var day = date.getDate();
			var month = date.getMonth() + 1;
			var year = date.getFullYear();

			if (month < 10)
				month = "0" + month;
			if (day < 10)
				day = "0" + day;

			var today = year + "-" + month + "-" + day;
			$("#theDate").attr("value", today);
		});
	</script>
</body>
</html>