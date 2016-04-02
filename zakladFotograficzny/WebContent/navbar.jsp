<div class="nav">
				<ul id="navigation">
					<li><a href="#">Strona Glowna</a></li>
					<li><a href="#">Link 2</a></li>
					<li><a href="#">Link 3</a></li>
					<%
						if (session.getAttribute("currentSessionUser") != null) {
					%>
					<li><a href="logout.jsp">Wyloguj</a></li>
					<%
						}
					%>
				</ul>
			</div>