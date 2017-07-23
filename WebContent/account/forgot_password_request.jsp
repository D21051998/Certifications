
<html>
<head>
<title>Home Page</title>
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
	transform: translateY(-50%);
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

</head>

<input type="hidden" id="refreshed" value="no">
<script type="text/javascript">
	onload = function() {
		var e = document.getElementById("refreshed");
		if (e.value == "no")
			e.value = "yes";
		else {
			e.value = "no";
			location.reload();
		}
	}
</script>
<body>



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

				<form method="POST" action="../ForgotPassword">
					<table>

						<tr>
							<td><label for="username">Enter Username</label></td>
						</tr>
						<tr>
							<td><input type="text" name="username" id="username"></td>
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

</body>
</html>