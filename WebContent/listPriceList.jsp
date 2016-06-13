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
			<form action="PriceListController" method="POST" class="formPriceList">
				Platnosc - Przelew: <input type="number" name="paymentPrzelew" value="<%= list.getPaymentPrzelew() %>"> <br />
				Platnosc - Gotowka: <input type="number" name="paymentGotowka" value="<%= list.getPaymentGotowka() %>"> <br />
				Transport - Kurier: <input type="number" name="shipmentKurier" value="<%= list.getShipmentKurier() %>"> <br />
				Transport - List Polecony: <input type="number" name="shipmentPolecony" value="<%= list.getShipmentPolecony() %>"> <br />
				Transport - List Eko: <input type="number" name="shipmentEko" value="<%= list.getShipmentEko() %>"> <br />
				Format Zdjecia - 9x13: <input type="number" name="photoFormat9x13" value="<%= list.getPhotoFormat9x13() %>"> <br />
				Format Zdjecia - 10x15: <input type="number" name="photoFormat10x15" value="<%= list.getPhotoFormat10x15() %>"> <br />
				Format Zdjecia - 13x18: <input type="number" name="photoFormat13x18" value="<%= list.getPhotoFormat13x18() %>"> <br />
				Retouch - Brak: <input type="number" name="retouchNone" value="<%= list.getRetouchNone() %>"> <br />
				Retouch - Czerwone Oczy: <input type="number" name="retouchEyes" value="<%= list.getRetouchEyes() %>"> <br />
				Retouch - Montage: <input type="number" name="retouchMontage" value="<%= list.getRetouchMontage() %>"> <br />
				Laminowanie - Brak: <input type="number" name="sealingNone" value="<%= list.getSealingNone() %>"> <br />
				Laminowanie - Calosc: <input type="number" name="sealingFull" value="<%= list.getSealingFull() %>"> <br />
				<input type="submit" value="OK" />
			</form>
			
			
		</div>


		</div>
	</div>



</body>
</html>