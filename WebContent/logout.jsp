<%
session.setAttribute("currentSessionUser", null);
session.invalidate();
response.sendRedirect("home.jsp");
%>