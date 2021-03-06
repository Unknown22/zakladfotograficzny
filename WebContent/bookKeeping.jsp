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

	<div class="userListDiv">
		<div class="container">
			
			<h3>Ksiegowosc</h3>
			<table id="tablepaging"  class="table table-hover">
				<thead>
					<tr>
						<th>Obrot calkowity</th>
						<th>Wysylki</th>
						<th>Obsluga i ksiegowanie</th>
						<th>Papier - rodzaj</th>
						<th>Obrobka zdjec</th>
						<th>Laminowanie</th>
						</thead>
				<tbody>
						<tr>
							<td>${income}</td>
							<td>${shipmentIncome}</td>
							<td>${paymentIncome}</td>
							<td>${phFormatIncome}</td>
							<td>${retouchIncome}</td>
							<td>${sealingIncome}</td>
						</tr>
				</tbody>
			</table>

		</div>
	</div>



</body>
</html>