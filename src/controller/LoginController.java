package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import model.Login;

public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6988619627621603507L;
	private LoginDao dao;
	private Login login;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		login = new Login();
		dao = new LoginDao();
		HttpSession session = request.getSession(true);

		login.setLogin(request.getParameter("username"));
		login.setPass(request.getParameter("password"));

		System.out.println("LoginController: received data: " + login);
		System.out.println("LoginController: validate");

		boolean validationStatus = dao.validate(login);

		System.out.println("validationStatus: " + validationStatus);

		if (validationStatus) {
			System.out.println("LoginController: validate OK");

			session.setAttribute("currentSessionUser", login.getLogin());
			response.sendRedirect("home.jsp");
		} else {
			System.out.println("LoginController: validate notOK");
			response.sendRedirect("login.jsp");
		}

	}

}
