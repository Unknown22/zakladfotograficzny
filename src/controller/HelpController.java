package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HelpDao;
import model.Help;


public class HelpController extends HttpServlet{
	
	private static final long serialVersionUID = -6463179069092857254L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		System.out.println("\nPassed parameters:");
		Enumeration<String> paramNames = request.getParameterNames();
	
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			System.out.print(paramName + ": ");
			String paramValue = request.getParameter(paramName);
			System.out.println(paramValue);
		}
		
		
		HelpDao helpDao = new HelpDao();

		String email = request.getParameter("Email");
		String message = request.getParameter("Message");


		Help help  = new Help(email,message);
		helpDao.sendHelp(help);
		
		response.sendRedirect("home.jsp");
	}
}
