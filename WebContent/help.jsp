<!doctype html>
<html>
<head>
<link rel="stylesheet"
	href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Merriweather'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

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

	<div class="help">
		<div class="container">
			
			<form action='HelpController' method="post" name="help_Form" class="form-help" >
			  
			  
    			<label class='bigLabel'>Wpisz swoj email, odpowiemy na niego:</label>
			  	<input type="text" class="form-control" name="Email" value='' required />
			  	</br>
			  	<label class='bigLabel'>Wpisz swoja wiadomosc:</label>
			  	<input type="text" class="form-control" name="Message" value='' required />

			  
			  <button name="send" type="submit" value="Submit" class="btn">Wyslij</button>  
			  
			  		
		</form>
			

		</div>
	</div>



</body>
</html>