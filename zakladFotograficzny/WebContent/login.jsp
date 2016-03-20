<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='style_login.css'/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <title>Login</title>
    </head>
    <body>
    
    
    <div class = "container">
	<div class="wrapper">
		<form action='LoginController' method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">Zaloguj sie!</h3>
			  
			  <input type="text" class="form-control" name="username" placeholder="Login" required="" autofocus="" />
			  <input type="password" class="form-control" name="password" placeholder="Haslo" required=""/>     		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" type="submit" value="Submit">Zaloguj</button>  			
		</form>			
	</div>
</div>
    

</html>