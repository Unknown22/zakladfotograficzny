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
	
	

	<div class="helpListDiv">
		<div class="container">

			
			<h3>Wiadomosci o pomoc</h3>
			<table id="tablepaging"  class="table table-hover">
				<thead>
					<tr>
						<th><p align="center">ID</p></th>
						<th><p align="center">Email</p></th>
						<th><p align="center">Wiadomosc</p></th>
						<th colspan=2>Akcje</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${help}" var="help">
						<tr>
							<td><c:out value="${help.id_help}" /></td>
							<td><c:out value="${help.email}" /></td>
							<td><c:out value="${help.message}" /></td>
							<td><a href="HelpController?action=deleteHelp&id_help=<c:out value="${help.id_help}"/>"><buttontype="button" class="btn btn-danger btn-sm">Usun</button></a></td>
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