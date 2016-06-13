<jsp:useBean id="user" class="model.Login" scope="session"></jsp:useBean>
<%
session.setAttribute("currentSessionUser", null);
user.setAuthorization(-1);
session.invalidate();
response.sendRedirect("home.jsp");
%>