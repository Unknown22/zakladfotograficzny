<div class="nav">
	<ul id="navigation">
		<li><a href="home.jsp">Strona Glowna</a></li>
		<li><a href="#">Link 2</a></li>
		
		<%
			if (session.getAttribute("currentSessionUser") != null) {
		%>
		<li><a href="indexUsers.jsp">Uzytkownicy</a></li>
		<li><a href="logout.jsp">Wyloguj</a></li>
		<%
			} else {
		%>
		<li><a href="login.jsp">Zaloguj sie</a></li>
		<li><a href="registration.jsp">Rejestracja</a></li>
		<%
			}
		%>
	</ul>
</div>