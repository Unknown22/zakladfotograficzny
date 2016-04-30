package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.OrderDao;
import dao.UserDao;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = -6463179069092857254L;
	private User user;
	private UserDao userDao;

	private String LIST_USER = "/listUsers.jsp";
	private String LIST_CLIENTS = "/listClients.jsp";
	private String LIST_EMPLOYEES = "/listEmployees.jsp";
	

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		UserDao dao = new UserDao();
		OrderDao orderDao = new OrderDao();
		System.out.println("CONTROLLER DO GET");

		if (action.equals("listUsers")) {

			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());

		} else if (action.equals("listClients")) {

			forward = LIST_CLIENTS;
			request.setAttribute("clients", dao.getAllClients());
			
		} else if (action.equals("listEmployees")) {

			forward = LIST_EMPLOYEES;
			request.setAttribute("employees", dao.getAllEmployee());

		} else if (action.equals("delete")) {
			int id_user = Integer.parseInt(request.getParameter("id_user"));
			dao.deleteUser(id_user);
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		}else if (action.equals("deleteEmp")) {
			int id_user = Integer.parseInt(request.getParameter("id_user"));
			dao.deleteUser(id_user);
			forward = LIST_EMPLOYEES;
			request.setAttribute("employees", dao.getAllEmployee());
		}else if (action.equals("deleteCli")) {
			int id_user = Integer.parseInt(request.getParameter("id_user"));
			dao.deleteUser(id_user);
			forward = LIST_CLIENTS;
			request.setAttribute("clients", dao.getAllClients());
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesja=request.getSession(true);
		sesja.setAttribute("error", null);
		user = new User();
		userDao = new UserDao();
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setLogin(request.getParameter("login"));
		user.setPass(request.getParameter("password"));
		user.setIdAccountType(2); // normal user account_type is 2
		// String dep=request.getParameter("department");
		// int integerDep=Integer.parseInt(dep);
		// user.setIdDepartment(integerDep);
		
		System.out.println("UserController: received data: " + user);
		if(isValidEmailAddress(user.getEmail())==false)
		{
			sesja.setAttribute("error", "incorrectPassword");
			response.sendRedirect("registration.jsp");
		}
		else if(isThatLoginInDatabase(user.getLogin())==true)
		{
			sesja.setAttribute("error", "loginDuplicated");
			response.sendRedirect("registration.jsp");
		}
		else
		{
			userDao.createUser(user);
			System.out.println("User inserted OK");
			response.sendRedirect("home.jsp");
		}
	}
	
	public static boolean isValidEmailAddress(String email) {
		   for(int i=0; i<email.length(); i++)
		   {
			   if(email.charAt(i)=='@')
			   {
				   for(int j=i; j<email.length(); j++)
				   {
					   if(email.charAt(j)=='.')
						   return true;
				   }
			   }
		   }
		   return false;
		}
	
	public static boolean isThatLoginInDatabase(String login){
		List<User> users = new ArrayList<User>();
		UserDao userDao = new UserDao();
		users=userDao.getAllUsers();
		for(User user: users)
		{
			if(user.getLogin().equals(login))
				return true;
		}
		return false;
	}
}
