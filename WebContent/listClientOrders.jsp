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
	
	

	<div class="userListDiv">
		<div class="containerOrder">
		

			
			
			
			<h3>Zamowienia</h3></br>
			<table id="tablepaging"  class="table table-hover table-order">
				<thead>
					<tr>
						<th>ID</th>
						<th>Status</th>
						<th>Data utworzenia</th>
						<th>Data edycji</th>
						<th>Dodatkowe informacji</th>
						<th>Platnosc</th>
						<th>Wysylka</th>
						<th>ID zakladu</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orders}" var="orders">
						<tr>
							<td><c:out value="${orders.id}" /></td>
							<td>
								<c:if test = "${orders.idStatus == 1 }">
									<c:out value="Oczekujace"/>
								</c:if>
								<c:if test = "${orders.idStatus != 1 }">
									<c:out value="Inne"/>
								</c:if>
							</td>
							<td><c:out value="${orders.creationTime}" /></td>
							<td><c:out value="${orders.lastEditTime}" /></td>
							<td><c:out value="${orders.addedInfo}" /></td>
							
							<c:if test = "${orders.idPayment == 1}">
								<td><c:out value="Przelew"/></td>
							</c:if>	
							<c:if test = "${orders.idPayment == 2}">
								<td><c:out value="Gotowka"/></td>
							</c:if>	
							
							<c:if test = "${orders.idShippment == 1}">
								<td><c:out value="Kurier"/></td>
							</c:if>	
							<c:if test = "${orders.idShippment == 2}">
								<td><c:out value="List Polecony"/></td>
							</c:if>	
							<c:if test = "${orders.idShippment == 3}">
								<td><c:out value="List Eko"/></td>
							</c:if>	
							
							<td><c:out value="${orders.idDepartment}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				
		<div id="pageNavPosition" style="padding-top: 20px" align="center">
		</div>


		</div>
	</div>



</body>
</html>