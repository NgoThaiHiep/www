package Shopping.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Shopping.daoImp.BookDao;
import Shopping.daoImp.BookDaoImp;
import Shopping.enity.ItemCart;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductDeltailsController
 */
@WebServlet(urlPatterns = {"/productDetail", "/productDetail*"})
public class ProductDeltailsController extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/shoppingBoook")
	private DataSource dataSource;
	private BookDao bookDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
    public ProductDeltailsController() {
        super();
        System.out.println("data source: " + dataSource);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	bookDao = new BookDaoImp(this.dataSource);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		 System.out.println("action: " + action);
	        switch (action) {
	            case "showProduct":
	                showProductDetail(request, response);
	                break;
	            default:
	                showProductDetailsPage(request, response);
	                break;
	        }
	}
	private void showProductDetail(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		System.out.println("showProductDetail");
		int bookID = Integer.parseInt(request.getParameter("id"));
	    ItemCart item = new ItemCart(bookDao.getByID(bookID));
	    request.setAttribute("productDetail", item);
	    request.getRequestDispatcher("/views/productDetail/index.jsp").forward(request, response);
		
	}
	 private void showProductDetailsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("views/productDetail/index.jsp").forward(request, response);
	 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
