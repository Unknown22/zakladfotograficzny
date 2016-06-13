<div class="nav">
	<ul id="navigation">
		<li><a href="home.jsp">Strona Glowna</a></li>
		<jsp:useBean id="user" class="model.Login" scope="session"></jsp:useBean>
		<%
		System.out.println( "Authorization number :"  + user.getAuthorization());

			if ( session.getAttribute("currentSessionUser") != null  && user.getAuthorization() == 1) {
		%>
		<li><a href="indexClients.jsp">Zarzadzaj</a></li>
		<li><a href="indexPriceList.jsp">Cennik</a></li>
		<li><a href="indexHelp.jsp">Zgloszenia pomocy</a></li>
		<li><a href="BookKeepingController?">Ksiegowosc</a></li>
		<li><a href="logout.jsp">Wyloguj</a></li>
		
		<%  } else if( session.getAttribute("currentSessionUser") != null  && user.getAuthorization() == 2) {
			%>
			
		<li><a href="listClientOrders.jsp">Sprawdz swoje zamówienia</a></li>
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