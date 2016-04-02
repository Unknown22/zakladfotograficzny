<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZAKLAD FOTO</title>
<link rel="stylesheet" type="text/css" href="js/style1.css">


</head>
<body>

	<div class="header">
		<h1>ZAKLAD FOTOGRAFICZNY ALPHA</h1>
	</div>

	<div class="srodek">

		<div class="lewo">
			<%@ include file="navbar.jsp"%>
			

			<div class="news">
				<p>Newsy</p>

				<%
					if (session.getAttribute("currentSessionUser") != null) {
				%>
				<p>
					Witaj:
					<%=session.getAttribute("currentSessionUser")%>
				</p>

				<%
					}
				%>

			</div>

		</div>

		<div class="wrapper">

			<%
				if ((session.getAttribute("currentSessionUser") == null)
						|| (session.getAttribute("currentSessionUser") == "")) {
			%>
			<%@ include file="notLogged.jsp"%>

			<%
				} else {
			%>
			<h3>
				Witaj:
				<%=session.getAttribute("currentSessionUser")%>,
			</h3>

			<%
				}
			%>


		</div>

	</div>

	<div class="footer">@2016 Stopka</div>

</body>
</html>