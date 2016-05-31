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
import dao.OrderDao;
import dao.UserDao;
import model.Help;


public class HelpController extends HttpServlet{
	
	private String LIST_HELP = "/listHelp.jsp";

	
	private static final long serialVersionUID = -6463179069092857254L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		HelpDao dao = new HelpDao();
		System.out.println("CONTROLLER DO GET");

		if (action.equals("listHelp")) {

			forward = LIST_HELP;
			request.setAttribute("help", dao.getAllHelpMessage());

		}else if (action.equals("deleteHelp")) {
			int id_help = Integer.parseInt(request.getParameter("id_help"));
			dao.deleteHelp(id_help);
			forward = LIST_HELP;
			request.setAttribute("help", dao.getAllHelpMessage());
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
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
		
		response.sendRedirect("message_send.jsp");
	}
}
