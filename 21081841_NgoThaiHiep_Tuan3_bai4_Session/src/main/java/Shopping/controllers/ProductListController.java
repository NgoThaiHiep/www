package Shopping.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import Shopping.daoImp.ProductDao;
import Shopping.daoImp.ProductDaoImp;
import Shopping.entity.Product;


/**
 * Servlet implementation class ProductListController
 */
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/Shopping")
	private DataSource dataSource;
	private ProductDao productDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	try {
    		System.out.println(this.dataSource.getConnection());
    		
    	}catch (SQLException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	productDao = new ProductDaoImp(this.dataSource);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product p1 = new Product("Product1", 50000, "image1.png");
		productDao.addProduct(p1);
		Product p2 = new Product("Product2", 20000, "image2.png");
		productDao.addProduct(p2);
		Product p3 = new Product("Product3", 40000, "image3.png");
		productDao.addProduct(p3);
		Product p4 = new Product("Product4", 80000, "image4.png");
		productDao.addProduct(p4);
		Product p5 = new Product("Product5", 100000, "image5.png");
		productDao.addProduct(p5);
		
		
		request.setAttribute("products", productDao.findAll());
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/views/product/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
