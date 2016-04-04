<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZAKLAD FOTOGRAFICZNY</title>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%//mozesz to odkomentowac aby byla tabela z bootstrapa BETA //<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> %>

<link rel="stylesheet" type="text/css" href="css/style1.css">
</head>
<body>

	<%@ include file="siteElements/header.jsp"%>

	<div class="srodek">

		<div class="lewo">
		
			<%@ include file="siteElements/navbar.jsp"%>
			
			<%@ include file="siteElements/news.jsp"%>

		</div>

		<div class="wrapper">

				<div class="container">

			<h3>Uzytkownicy</h3>
			<table id="tablepaging"  class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Imie</th>
						<th>Nazwisko</th>
						<th>Email</th>
						<th>Login</th>
						<th>Typ konta</th>
						<th colspan=2>Akcje</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td><c:out value="${user.id_user}" /></td>
							<td><c:out value="${user.firstname}" /></td>
							<td><c:out value="${user.lastname}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.login}" /></td>
							<td><c:out value="${user.idAccountType}" /></td>
							<td><a href="UserController?action=delete&id_user=<c:out value="${user.id_user}"/>">
								<buttontype="button" class="btn btn-danger btn-sm">Usun</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				
		<div id="pageNavPosition" style="padding-top: 20px" align="center">
		</div>
	</div>
	
				


		</div>

	</div>

	<%@ include file="siteElements/footer.jsp"%>

</body>
</html>