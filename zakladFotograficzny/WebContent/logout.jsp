<%
session.setAttribute("currentSessionUser", null);
session.invalidate();
response.sendRedirect("login.jsp");
%>