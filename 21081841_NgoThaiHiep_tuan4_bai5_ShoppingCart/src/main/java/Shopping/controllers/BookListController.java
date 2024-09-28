package Shopping.controllers;

import java.io.IOException;

import javax.sql.DataSource;

import Shopping.daoImp.BookDao;
import Shopping.daoImp.BookDaoImp;
import Shopping.enity.Book;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookListController
 */
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/shoppingBoook")
    private DataSource dataSource;
	
	private BookDao bookDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	 @Override
		public void init(ServletConfig conf) throws ServletException {
			super.init(conf);
			try {
	            System.out.println(this.dataSource.getConnection());
	        } catch (Exception e) {
	        	            e.printStackTrace();
	        }
			        bookDao = new BookDaoImp(this.dataSource);
		}

    public BookListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Book b1 = new Book("Sổ tay viết văn","Tô Hoài","", 99000,10, "imgSoTayVietVan.png");
//		bookDao.addBook(b1);
//		Book b2 = new Book("Nhật ký ma cà rồng 03 - CƠN THỊNH NỘ","","", 48000,10, "imgNhatKyMaCauRong03_ConThinhNo.jpg");
//		bookDao.addBook(b2);
//		Book b3 = new Book("Billy và Beth - 3 bí quyết của người thành đạt","","", 52000,10, "imgBilly&Beth_3BiQuyetCuaNguoiThanhDat.jpg");
//		bookDao.addBook(b3);
//		Book b4 = new Book("Bí ẩn một cái tên","","Nguyễn Hồng Dung", 33000,10, "imgBiAnMotCaiTen.jpg");
//		bookDao.addBook(b4);
//		Book b5 = new Book("Kẻ trộm sách","Markus Zusak","", 71000,10, "imgKeTromSach.jpg");
//		bookDao.addBook(b5);
//		Book b6 = new Book("Cơm & Phở","Xuân Sách","" ,120000,10, "imgCom&Pho.jpg");
//		bookDao.addBook(b6);
		
		
		
	    request.setAttribute("bookProductList", bookDao.findAll());
		for (Book book : bookDao.findAll()) {
			System.out.println(book.getTitle());
		}
		request.getRequestDispatcher("/views/DanhSachSP/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
