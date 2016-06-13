package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Order;
import model.Photo;
import model.User;
import dao.OrderDao;
import dao.PhotoDao;
import dao.UserDao;


@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
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
		User user = new User();

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
		}else if (action.equals("clientOrders")){
			System.out.println("clientOrders id: " + request.getParameter("id_user"));
			forward = LIST_ORDERS;
			int idUser = Integer.parseInt(request.getParameter("id_user"));
			request.setAttribute("orders", orderDao.getOrdersByClient(idUser));
			
		}
	else if (action.equals("listclientOrders")){
		System.out.println("clientOrders id: " + user.getId_user());
		forward = LIST_ORDERS;
		int idUser = user.getId_user();
		request.setAttribute("orders", orderDao.getOrdersByClient(idUser));
		
	}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		InputStream inputStream = null; // input stream of the upload file
		
		Part filePart = request.getPart("inputFile");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
		
		
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


		
//		File file = new File(request.getParameter("inputFile"));
		
		Photo photo = new Photo(tempID, filePart.getName(), serviceID, filePart.getContentType(), filePart.getSize(), inputStream);
		photoDao.uploadPhoto(photo);
		response.sendRedirect("confirmOrderSite.jsp");
		
	}
	

}
