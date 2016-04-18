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
		<div class="container">
		
		<%@ include file="siteElements/manageDropDown.jsp"%>
			
			
			
			<h3>Zamowienia</h3>
			<table id="tablepaging"  class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Status</th>
						<th>Data utworzenia</th>
						<th>Data edycji</th>
						<th>Dodatkowe informacji</th>
						<th>ID platnosci</th>
						<th>ID wysylki</th>
						<th>ID zakladu</th>
						<th colspan=2>Akcje</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orders}" var="orders">
						<tr>
							<td><c:out value="${orders.id}" /></td>
							<td><c:out value="${orders.idStatus}" /></td>
							<td><c:out value="${orders.creationTime}" /></td>
							<td><c:out value="${orders.lastEditTime}" /></td>
							<td><c:out value="${orders.addedInfo}" /></td>
							<td><c:out value="${orders.idPayment}" /></td>
							<td><c:out value="${orders.idShippment}" /></td>
							<td><c:out value="${orders.idDepartment}" /></td>
							<td><a href="OrderController?action=deleteOrder&id_order=<c:out value="${orders.id}"/>"><buttontype="button" class="btn btn-danger btn-sm">Usun</button></a></td>
							<td><a href="#"/><buttontype="button" class="btn btn-warning btn-sm">Zmien status</button></a></td>
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