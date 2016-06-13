package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dao.PaymentDao;
import dao.PhotoDao;
import dao.PhotoFormatDao;
import dao.PhotoServiceDao;
import dao.RetouchDao;
import dao.SealingDao;
import dao.ShipmentDao;
import model.Order;
import model.Photo;
import model.PhotoService;


@WebServlet("/BookKeepingController")
public class BookKeepingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookKeepingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(true);
		OrderDao orderDao=new OrderDao();
		PaymentDao paymentDao=new PaymentDao();
		ShipmentDao shipmentDao=new ShipmentDao();
		List <Order> orders=orderDao.getAllOrders();
		float income=0;
		float paymentIncome=0;
		float shipmentIncome=0;
		for(Order order : orders)
		{
			float tempPay=paymentDao.getPaymentPrice(order.getIdPayment());
			paymentIncome+=tempPay;
			income+=tempPay;
			float tempShip=shipmentDao.getshipmentPrice(order.getIdShippment());
			shipmentIncome+=tempShip;
			income+=tempShip;
		}
		session.setAttribute("paymentIncome", paymentIncome);
		session.setAttribute("shipmentIncome", shipmentIncome);
		
		float phFormatIncome=0;
		float retouchIncome=0;
		float sealingIncome=0;
		PhotoDao photoDao=new PhotoDao();
		PhotoServiceDao photoServiceDao=new PhotoServiceDao();
		PhotoFormatDao phformatDao=new PhotoFormatDao();
		RetouchDao retouchDao=new RetouchDao();
		SealingDao sealingDao=new SealingDao();
		List <Photo> photos=photoDao.getAllPhotos();
		for(Photo photo: photos)
		{
			int id_service=photo.getIdService();
			PhotoService phService=photoServiceDao.getPhotoServiceById(id_service);
			float tempPhFormat=phformatDao.getPhotoFormatPrice(phService.getId_photo_format());
			phFormatIncome+=tempPhFormat;
			income+=tempPhFormat;
			float tempretouch=retouchDao.getRetouchPrice(phService.getId_photo_format());
			retouchIncome+=tempretouch;
			income+=tempretouch;
			float tempSealing=sealingDao.getSealingPrice(phService.getId_photo_format());
			sealingIncome+=tempSealing;
			income+=tempSealing;
		}
		session.setAttribute("phFormatIncome", phFormatIncome);
		session.setAttribute("retouchIncome", retouchIncome);
		session.setAttribute("sealingIncome", sealingIncome);
		session.setAttribute("income", income);
		response.sendRedirect("bookKeeping.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
