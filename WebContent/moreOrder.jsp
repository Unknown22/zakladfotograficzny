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
		
		<%@ include file="siteElements/manageDropDown.jsp"%>
			
			
			
			<h3>Zamowienie ID <c:out value="${order.id}"/></h3>
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
						<tr>
							<td><c:out value="${order.id}" /></td>
							<td>
								<c:if test = "${order.idStatus == 1 }">
									<c:out value="Oczekujace"/>
								</c:if>
								<c:if test = "${order.idStatus != 1 }">
									<c:out value="Inne"/>
								</c:if>
							</td>
							<td><c:out value="${order.creationTime}" /></td>
							<td><c:out value="${order.lastEditTime}" /></td>
							<td><c:out value="${order.addedInfo}" /></td>
							<td><c:out value="${order.idPayment}" /></td>
							<td><c:out value="${order.idShippment}" /></td>
							<td><c:out value="${order.idDepartment}" /></td>
							<td><a href="OrderController?action=delete&id_order=<c:out value="${order.id}"/>"><buttontype="button" class="btn btn-danger btn-sm">Usun</button></a></td>
						</tr>
				</tbody>
			</table>
				
		<div id="pageNavPosition" style="padding-top: 20px" align="center">
		</div>


		</div>
	</div>



</body>
</html>