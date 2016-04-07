<!doctype html>
<html>
<head>
<link rel="stylesheet" href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Merriweather' rel='stylesheet' type='text/css'>
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

	<div class="supporting">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<a href="#" ><img src="img/read.svg" /></a>
					<h2>Galeria</h2>
					<p>Zobacz nasze osiagniecia.</p>
				</div>

				<div class="col-md-4">
					<a href="#" ><img src="img/write.svg" /></a>
					<h2>Zloz zamowienie</h2>
					<p>Wyslij nam swoje zdjecia. Nasi specjaliscji zajma sie ich wywolaniem.</p>
				</div>

				<div class="col-md-4">
					<a href="#" ><img src="img/talk.svg" /> </a>
					<h2>Czat</h2>
					<p>Porozmawiaj z naszymi konsultantami. Rozwieja Twoje watpliwosci</p>
				</div>
			</div>


		</div>
	</div>



</body>
</html>