package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.PriceListDao;
import model.PriceList;

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
		}else{
			forward = LIST;
			request.setAttribute("pricelist", dao.getPriceList());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration paramNames = request.getParameterNames();

		
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			System.out.print(paramName + ": ");
			String paramValue = request.getParameter(paramName);
			System.out.print(paramValue +"\n");
		}
		
		
		PriceList list = new PriceList();
		
		list.setPaymentGotowka(Integer.parseInt(request.getParameter("paymentGotowka")));
		list.setPaymentPrzelew(Integer.parseInt(request.getParameter("paymentPrzelew")));
		
		list.setShipmentKurier(Integer.parseInt(request.getParameter("shipmentKurier")));
		list.setShipmentPolecony(Integer.parseInt(request.getParameter("shipmentPolecony")));
		list.setShipmentEko(Integer.parseInt(request.getParameter("shipmentEko")));
		
		list.setPhotoFormat9x13(Integer.parseInt(request.getParameter("photoFormat9x13")));
		list.setPhotoFormat10x15(Integer.parseInt(request.getParameter("photoFormat10x15")));
		list.setPhotoFormat13x18(Integer.parseInt(request.getParameter("photoFormat13x18")));
		
		list.setRetouchNone(Integer.parseInt(request.getParameter("retouchNone")));
		list.setRetouchEyes(Integer.parseInt(request.getParameter("retouchEyes")));
		list.setRetouchMontage(Integer.parseInt(request.getParameter("retouchMontage")));
		
		list.setSealingNone(Integer.parseInt(request.getParameter("sealingNone")));
		list.setSealingFull(Integer.parseInt(request.getParameter("sealingFull")));
		
		PriceListDao dao = new PriceListDao();
		dao.savePriceList(list);
//		doGet(request, response);
		response.sendRedirect("indexPriceList.jsp");
	}

}
