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
		} else{ %>
		<p>Jestes niezalogowany</p>
		<%
			
		}
	%>

</div>