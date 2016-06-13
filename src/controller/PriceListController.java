package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.PriceListDao;

/**
 * Servlet implementation class PriceListController
 */
@WebServlet("/PriceListController")
public class PriceListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String LIST = "/listPriceList.jsp";
       

    public PriceListController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		PriceListDao dao = new PriceListDao();
		System.out.println("CONTROLLER DO GET PRICELIST");
		
		if (action.equals("getPriceList")){
			forward = LIST;
			request.setAttribute("pricelist", dao.getPriceList());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
