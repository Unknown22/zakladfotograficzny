<!doctype html>
<html>
<head>
<link rel="stylesheet"
	href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Merriweather'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="header">
		<div class="container">

			<%@ include file="siteElements/navbar.jsp"%>

		</div>
	</div>

	<div class="jumb">
		<%@ include file="siteElements/header.jsp"%>

	</div>

	<div class="loginDiv">
		<div class="container">
			<form action='LoginController' method="post" name="Login_Form" class="form-signin">
						<h3 class="form-signin-heading">Zaloguj sie!</h3>

						<input type="text" class="form-control" name="username" placeholder="Login" /> 
						<input type="password" class="form-control" name="password" placeholder="Haslo" />

						<button class="btn btn-lg btn-primary btn-block" name="Submit" type="submit" value="Submit">Zaloguj</button>
					</form>

		</div>
	</div>



</body>
</html>