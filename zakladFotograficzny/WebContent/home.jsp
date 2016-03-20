<!DOCTYPE html>
<html>
<head>
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,300,500,100'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel='stylesheet' href='style.css' />
<title>Zaklad Fotograficzny</title>
</head>
<body>



	<div class="header">
		<div class="container">
			<h1>Zaklad Fotograficzny</h1>
		</div>
	</div>



	<%
		if ((session.getAttribute("currentSessionUser") == null)
				|| (session.getAttribute("currentSessionUser") == "")) {
	%>
	<%@ include file="notLogged.jsp"%>

	<%
		} else {
	%>


	<div class="main">
		<div class="container">
			<h3>
				Witaj:
				<%=session.getAttribute("currentSessionUser")%>,
			</h3>


		</div>
	</div>
	<%
		}
	%>
	<a href="logout.jsp"><li>Wyloguj</li></a>

</body>
</html>