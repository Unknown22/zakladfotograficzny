package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.UserDao;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = -6463179069092857254L;
	private User user;
	private UserDao userDao;
	
	private String LIST_USER = "/listUsers.jsp";
	
	

	public UserController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");
		UserDao dao = new UserDao();
		 System.out.println("CONTROLLER DO GET");
		 	 
		 
		 if(action.equals("listUsers")){
			 
			 forward = LIST_USER;
			 request.setAttribute("users", dao.getAllUsers() );
			 
		 }else if(action.equals("delete")){
			 int id_user = Integer.parseInt(request.getParameter("id_user"));
			 dao.deleteUser(id_user);
			 forward = LIST_USER;
			 request.setAttribute("users", dao.getAllUsers() );
		 }
		 
		 RequestDispatcher view = request.getRequestDispatcher(forward);
	     view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		user=new User();
		userDao=new UserDao();
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setLogin(request.getParameter("login"));
		user.setPass(request.getParameter("password"));
		user.setIdAccountType(2); //normal user account_type is 2
//		String dep=request.getParameter("department");
//		int integerDep=Integer.parseInt(dep);
//		user.setIdDepartment(integerDep);
		
		System.out.println("UserController: received data: "+ user);
		
		userDao.createUser(user);
		System.out.println("User inserted OK");
		response.sendRedirect("home.jsp");
	}
}
