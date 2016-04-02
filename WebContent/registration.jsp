<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rejestracja</title>
</head>
<body>
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
</body>
</html>