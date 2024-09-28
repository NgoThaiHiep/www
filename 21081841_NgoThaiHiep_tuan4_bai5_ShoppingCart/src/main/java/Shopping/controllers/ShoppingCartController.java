package Shopping.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Shopping.daoImp.BookDao;
import Shopping.daoImp.BookDaoImp;
import Shopping.enity.Book;
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
 * Servlet implementation class ShoppingCartController
 */
@WebServlet(urlPatterns = {"/shoppingCart", "/shoppingCart*"})
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/shoppingBoook")
	private DataSource dataSource;
	
	private BookDao bookDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartController() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println(dataSource);
    }

    @Override
    public void init(ServletConfig conf) throws ServletException{
    	super.init(conf);
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
			case "addCart":
				addCart(request, response);
				System.out.println("addCart123456");
				break;
			case "showProduct":
				 showProductDetailsPage(request, response);
				break;
			case "removeCart":
				removeCart(request, response);
				System.out.println("removeCart");
				break;
			case "checkout":
				checkout(request, response);
				System.out.println("checkout");
				break;
			 default:
				  showCart(request, response);
	         break;
			}
	}
	 private void checkout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		 
		 int total = 0;
		 HttpSession session = request.getSession();
		 List<ItemCart> shoppingCart = (List<ItemCart>) session.getAttribute("shoppingCart");
			for (ItemCart itemCart : shoppingCart) {
				total += itemCart.getQuantity() * itemCart.getBook().getPrice();
			}
			request.setAttribute("total", total);
			request.getRequestDispatcher("/views/checkOut/index.jsp").forward(request, response);
			
		
	}

	private void showProductDetailsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	System.out.println("showProductDetail");
			int bookID = Integer.parseInt(request.getParameter("id"));
		    ItemCart item = new ItemCart(bookDao.getByID(bookID));
		    request.setAttribute("productDetail", item);
		    request.getRequestDispatcher("/views/productDetail/index.jsp").forward(request, response);
			
	 }
		private void removeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			HttpSession session = request.getSession();
			List<ItemCart> shoppingCart = (List<ItemCart>) session.getAttribute("shoppingCart");
			int index = isProductExisting(Integer.parseInt(request.getParameter("id")), shoppingCart);
			shoppingCart.remove(index);
			session.setAttribute("shoppingCart", shoppingCart);
			response.sendRedirect("shoppingCart");
		}
	
		private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
	        List<ItemCart> shoppingCart = null;
	        String id = request.getParameter("id");
	        System.out.println("ID received: " +  id); // Kiểm tra id
	        
			if (session.getAttribute("shoppingCart") == null) {
				shoppingCart = new ArrayList<>();
				session.setAttribute("shoppingCart", shoppingCart);
				System.out.println("shoppingCartNULL");
			
			} else {
				shoppingCart = (List<ItemCart>) session.getAttribute("shoppingCart");
				System.out.println("shoppingCartNOTNULL");
			}
			
			int index = isProductExisting(Integer.parseInt( id), shoppingCart);
			  System.out.println("ID received: " +  id);
				
				System.out.println("bookDao: " + bookDao.getByID(Integer.parseInt( id)).getId());
	        if (index == -1) {
	        	shoppingCart.add(new ItemCart(bookDao.getByID(Integer.parseInt(id)), 1));
	        } else {
	            int quantity = shoppingCart.get(index).getQuantity() + 1;
	            shoppingCart.get(index).setQuantity(quantity);
	        }

	        session.setAttribute("shoppingCart", shoppingCart);
	        response.sendRedirect("shoppingCart");
			}

	private int isProductExisting(int bookID, List<ItemCart> shoppingCart) {
			// TODO Auto-generated method stub
			for (int i = 0; i < shoppingCart.size(); i++) {
				if (shoppingCart.get(i).getBook().getId() == bookID) {
					return i;
				}
				System.out.println("Checking if product exists, ID: " + bookID);
				System.out.println("Current shopping cart: " + shoppingCart);
			}
			return -1;
		}

	private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		  System.out.println("Showing Cart");
	       request.getRequestDispatcher("views/shoppingCart/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
