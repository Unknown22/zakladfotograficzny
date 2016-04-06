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

	<div class="regDiv">
		<div class="container">
			
				<h3>Nowy uzytkownik:</h3>
		<form action='UserController' method="post" name="Registration_Form" class="form-registration">
			  
			  <input type="text" class="form-control" name="firstname" placeholder="Imie" required />
			  <input type="text" class="form-control" name="lastname" placeholder="Nazwisko" required />
			  <input type="text" class="form-control" name="email" placeholder="E-mail" required />
			  <input type="text" class="form-control" name="login" placeholder="Login" required/>
			  <input type="password" class="form-control" name="password" placeholder="Haslo" required/>
			 
			  <button name="Registration" type="submit" value="Submit" class="btn">Zarejestruj</button>  			
		</form>

		</div>
	</div>



</body>
</html>