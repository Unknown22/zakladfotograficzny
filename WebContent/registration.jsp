<!doctype html>
<html>
<head>
<link rel="stylesheet"
	href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Merriweather'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style.css">
<title>Zaklad Foto</title>
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
			  <% if(session.getAttribute("error")!=null && session.getAttribute("error").equals("incorrectPassword")){%>
			  <p class="error">Niepoprawny adres e-mail</p>
			  <%} %>
			  <input type="text" class="form-control" name="login" placeholder="Login" required/>
			   <% if(session.getAttribute("error")!=null && session.getAttribute("error").equals("loginDuplicated")){%>
			  <p class="error">Login zajety</p>
			  <%} %>
			  <input type="password" class="form-control" name="password" placeholder="Haslo" required/>
			 
			  <button name="Registration" type="submit" value="Submit" class="btn">Zarejestruj</button>  			
		</form>
		</div>
	</div>



</body>
</html>