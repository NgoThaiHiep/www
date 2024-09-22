package Shopping.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;




import Shopping.daoImp.ProductDao;
import Shopping.daoImp.ProductDaoImp;
import Shopping.entity.ItemCart;

/**
 * Servlet implementation class CartItemcontroller
 */
@WebServlet(urlPatterns = {"/cart", "/cart*"})
public class CartItemcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/shopping")
	private DataSource dataSource;
	private ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemcontroller() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println(dataSource);
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	productDao = new ProductDaoImp(this.dataSource);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "buy":
			doGetBuy(request, response);
			break;
		case "remove":
			doGetRemove(request, response);
			break;
		default:
			doGetDisplayCart(request,response);
			break;
		}
		
	}

	private void doGetDisplayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/cart/index.jsp").forward(request, response);
	}

	private void doGetRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
		int index = isProductExisting(Integer.parseInt(request.getParameter("id")),cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

	private int isProductExisting(int id, List<ItemCart> cart) {
		for(int i = 0; i < cart.size() ; i ++) {
			if(cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
	private void doGetBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		HttpSession session = request.getSession();
		        List<ItemCart> cart = null;
				if (session.getAttribute("cart") == null) {
					cart = new ArrayList<>();
					session.setAttribute("cart", cart);
				} else {
					cart = (List<ItemCart>) session.getAttribute("cart");
				}
				int index = isProductExisting(Integer.parseInt(request.getParameter("id")), cart);
	        if (index == -1) {
	            cart.add(new ItemCart(productDao.getByID(Integer.parseInt(request.getParameter("id"))), 1));
	        } else {
	            int quantity = cart.get(index).getQuantity() + 1;
	            cart.get(index).setQuanlity(quantity);
	        }

	        session.setAttribute("cart", cart);
	        response.sendRedirect("cart");

	   
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
