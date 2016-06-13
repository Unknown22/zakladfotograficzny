package controller;

import java.io.File;
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

import model.Order;
import model.Photo;
import model.User;
import dao.OrderDao;
import dao.PhotoDao;
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
		
		
		OrderDao orderDao = new OrderDao();
		PhotoDao photoDao = new PhotoDao();

		
		String paymentS = request.getParameter("payment");
		String sendingS = request.getParameter("sending");
		
		int paymentInt = 1;
		int sendingInt = 3;
		
		if(paymentS.equals("transfer")){
			paymentInt = 1;
		}else if(paymentS.equals("cash")){
			paymentInt = 2;
		}
		
		if(sendingS.equals("courier")){
			sendingInt = 1;
		}else if(sendingS.equals("regiLetter")){
			sendingInt = 2;
		}else if(sendingS.equals("ekoLetter")){
			sendingInt = 3;
		}
		
		Order order = new Order(1, request.getParameter("textArea-add_info"), paymentInt, sendingInt, 0); //iddepartamentu trzeba poprawic
		orderDao.createOrder(order);
		int tempID = orderDao.getLastIDOrder();
		
		String service = request.getParameter("photoCorect");
		int serviceID = 0;
		if(service.equals("redEyes")){
			serviceID= 1;
		}
//		
//		String fileTyp = " ";
//		
//		String[] temp = request.getParameter("inputFile").split(".", 2);
//		fileTyp = temp[1];
		
//		File file = new File(request.getParameter("inputFile"));
		
		//Photo photo = new Photo(tempID, request.getParameter("inputFile"), serviceID, fileTyp, request.getParameter("inputFile").length(), file);
		//photoDao.uploadPhoto(photo);
		response.sendRedirect("confirmOrderSite.jsp");
		
	}
	

}
