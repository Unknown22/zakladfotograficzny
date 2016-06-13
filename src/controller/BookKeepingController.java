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
		for(Order order : orders)
		{
			income+=paymentDao.getPaymentPrice(order.getIdPayment());
			income+=shipmentDao.getshipmentPrice(order.getIdShippment());
		}
		
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
			income+=phformatDao.getPhotoFormatPrice(phService.getId_photo_format());
			income+=retouchDao.getRetouchPrice(phService.getId_photo_format());
			income+=sealingDao.getSealingPrice(phService.getId_photo_format());
		}
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
