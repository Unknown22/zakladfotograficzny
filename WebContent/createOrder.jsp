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

	<div class="createOrder">
		<div class="container">
			
			<form action='OrderController' method="post" name="order_Form" class="form-order" enctype="multipart/form-data" >
			  
			  
    			<input type="file" class="form-control-file" name="inputFile" id="InputFile" >

    			
    			<label class='bigLabel'>Liczba Kopii kazdego zdjecia:</label>
			  	<input type="number" class="form-control" name="copyNumber" value='1' required />
			  	
				
				<label class='bigLabel'>Format Zdjecia:</label>
				  <select class="form-control" id="sel1" name="format">
				    <option value="9x13">9x13</option>
				    <option value="10x15">10x15</option>
				    <option value="13x18">13x18</option>
				  </select>
			  	
			  	
			  	<label class='bigLabel'>Papier:</label>
				  <select class="form-control" id="sel1" name="paperType">
				    <option value="matte">Matowy</option>
				    <option value="shine">Blyszczacy</option>
				  </select>
				  
				  <label class='bigLabel'>Korekta:</label>
				  <select class="form-control" id="sel1" name="photoCorect">
				    <option value="none">Brak</option>
				    <option value="redEyes">Korekta czerwonych oczu</option>
				    <option value="other">Inna Korekta - prosze opisac w polu 'Dodatkowe Informacje'</option>
				  </select>
			  	
			  	 <label class='bigLabel'>Dodatkowe Informacje:</label>
			  	<textarea class="form-control" rows="3" name="textArea-add_info" placeholder="Dodatkowe informacje..."></textarea>
			  	
			  	
			  	<div class="form-group">
				  <label class='bigLabel'>Wybierz sposob zaplaty:</label>
				  <select class="form-control" id="sel1" name="payment">
				    <option value="transfer">Przelew</option>
				    <option value="cash">Gotowka</option>
				  </select>
				</div>
				
				<div class="form-group">
				  <label class='bigLabel'>Wybierz sposob wysylki:</label>
				  <select class="form-control" id="sel1" name="sending">
				    <option value="ekoLetter">Poczta Polska - List ekonomiczny - 3,40 zl</option>
				    <option value="regiLetter">Poczta Polska - List polecony - 7,50 zl</option>
				    <option value="courier">Kurier - 10,00 zl</option>
				  </select>
				</div>
			  
			  <button name="send" type="submit" value="Submit" class="btn">Wyslij</button>  
			  
			  		
		</form>
			

		</div>
	</div>



</body>
</html>