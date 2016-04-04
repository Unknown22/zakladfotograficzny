<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZAKLAD FOTOGRAFICZNY</title>

<link rel="stylesheet" type="text/css" href="css/style1.css">

</head>
<body>

	<%@ include file="siteElements/header.jsp"%>

	<div class="srodek">

		<div class="lewo">

			<%@ include file="siteElements/navbar.jsp"%>

			<%@ include file="siteElements/news.jsp"%>

		</div>

		<div class="wrapper">

			<div class="container">
				<div class="wrapper">
					<form action='LoginController' method="post" name="Login_Form"
						class="form-signin">
						<h3 class="form-signin-heading">Zaloguj sie!</h3>

						<input type="text" class="form-control" name="username" placeholder="Login" /> 
						<input type="password" class="form-control" name="password" placeholder="Haslo" />

						<button class="btn btn-lg btn-primary btn-block" name="Submit" type="submit" value="Submit">Zaloguj</button>
					</form>
				</div>
			</div>


		</div>

	</div>

	<%@ include file="siteElements/footer.jsp"%>

</body>
</html>