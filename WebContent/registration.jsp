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
		Nowy uzytkownik:
		<form action='UserController' method="post" name="Registration_Form" class="form-registration">
			  
			  <input type="text" class="form-control" name="firstname" placeholder="Imie" required="" autofocus="" /></br>
			  <input type="text" class="form-control" name="lastname" placeholder="Nazwisko" required="" /></br>
			  <input type="text" class="form-control" name="email" placeholder="E-mail" required="" /></br>
			  <input type="text" class="form-control" name="login" placeholder="Login" required="" /></br>
			  <input type="password" class="form-control" name="password" placeholder="Haslo" required=""/></br>   		  
			 
			  <button name="Registration" type="submit" value="Submit">Zarejestruj</button>  			
		</form>

		</div>

	</div>

	<%@ include file="siteElements/footer.jsp"%>

</body>
</html>