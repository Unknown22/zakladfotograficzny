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



public class OrderController extends HttpServlet{
	
	private static final long serialVersionUID = -6463179069092857254L;
	
	private String LIST_ORDERS = "/listOrders.jsp";
	
	public OrderController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		OrderDao orderDao = new OrderDao();
		System.out.println("CONTROLLER DO GET");

		if (action.equals("listOrders")){
			
			forward = LIST_ORDERS;
			request.setAttribute("orders", orderDao.getAllOrders());
			
		} else if (action.equals("delete")) {
			int id_user = Integer.parseInt(request.getParameter("id_order"));
			orderDao.deleteOrder(id_user);
			forward = LIST_ORDERS;
			request.setAttribute("orders", orderDao.getAllOrders());
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
