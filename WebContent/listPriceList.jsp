<!doctype html>
<html>
<head>
<link rel="stylesheet" href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Merriweather' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style.css">
<title>Zaklad Foto</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	<%@ page import="model.PriceList" %>
	

	<div class="userListDiv">
		<div class="containerOrder">
		
		<%@ include file="siteElements/manageDropDown.jsp"%>
			<% PriceList list = new PriceList();
			list = (PriceList) request.getAttribute("pricelist"); %>
			
			
			<h3>Cennik</h3></br>
			<table id="tablepaging"  class="table table-hover table-order">
				<thead>
					<tr>
						<th>Nazwa</th>
						<th>Cena (PLN)</th>
					</tr>
				</thead>
				<tbody>
					
						<tr>
							<td>Platnosc - Przelew</td>
							<td><%= list.getPaymentPrzelew() %></td>					
						</tr>
						
						<tr>
							<td>Platnosc - Gotowka</td>
							<td><%= list.getPaymentGotowka() %></td>					
						</tr>
						
						<tr>
							<td>Transport - Kurier</td>
							<td><%= list.getShipmentKurier() %></td>					
						</tr>
						
						<tr>
							<td>Transport - List Polecony</td>
							<td><%= list.getShipmentPolecony() %></td>					
						</tr>
						
						<tr>
							<td>Transport - List Eko</td>
							<td><%= list.getShipmentEko() %></td>					
						</tr>
						<tr>
							<td>Format Zdjecia - 9x13</td>
							<td><%= list.getPhotoFormat9x13() %></td>					
						</tr>
						<tr>
							<td>Format Zdjecia - 10x15</td>
							<td><%= list.getPhotoFormat10x15() %></td>					
						</tr>
						<tr>
							<td>Format Zdjecia - 13x18</td>
							<td><%= list.getPhotoFormat13x18() %></td>					
						</tr>
						
						<tr>
							<td>Retouch - Brak</td>
							<td><%= list.getRetouchNone() %></td>					
						</tr>
						<tr>
							<td>Retouch - Czerwone Oczy</td>
							<td><%= list.getRetouchEyes() %></td>					
						</tr>
						
						<tr>
							<td>Retouch - Montage</td>
							<td><%= list.getRetouchMontage() %></td>					
						</tr>
						
						<tr>
							<td>Laminowanie - Brak</td>
							<td><%= list.getSealingNone() %></td>					
						</tr>
						<tr>
							<td>Laminowanie - Calosc</td>
							<td><%= list.getSealingFull() %></td>					
						</tr>
						
						
					
				</tbody>
			</table>
				
		<div id="pageNavPosition" style="padding-top: 20px" align="center">
		</div>


		</div>
	</div>



</body>
</html>