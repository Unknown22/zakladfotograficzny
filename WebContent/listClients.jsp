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
			
			
			
			<h3>Klienci</h3>
			<table id="tablepaging"  class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Imie</th>
						<th>Nazwisko</th>
						<th>Email</th>
						<th>Login</th>
						<th colspan=2>Akcje</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clients}" var="client">
						<tr>
							<td><c:out value="${client.id_user}" /></td>
							<td><c:out value="${client.firstname}" /></td>
							<td><c:out value="${client.lastname}" /></td>
							<td><c:out value="${client.email}" /></td>
							<td><c:out value="${client.login}" /></td>
							<td><a href="UserController?action=delete&id_user=<c:out value="${client.id_user}"/>"><buttontype="button" class="btn btn-danger btn-sm">Usun</button></a></td>
							<td><a href="#"/><buttontype="button" class="btn btn-warning btn-sm">Pokaz zamowienia</button></a></td>
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