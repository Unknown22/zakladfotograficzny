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
	private String MORE_ORDER = "/moreOrder.jsp";
	
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
			int id_order = Integer.parseInt(request.getParameter("id_order"));
			orderDao.deleteOrder(id_order);
			forward = LIST_ORDERS;
			request.setAttribute("orders", orderDao.getAllOrders());
		} else if (action.equals("showMore")){
			int id_order = Integer.parseInt(request.getParameter("id_order"));
			forward = MORE_ORDER;
			request.setAttribute("order", orderDao.showOrder(id_order));
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
