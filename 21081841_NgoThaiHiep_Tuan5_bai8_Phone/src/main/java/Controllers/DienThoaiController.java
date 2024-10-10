package Controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.EntityManegeFactoryUtil;

import java.io.IOException;

import dao.DienThoaiDAOImp;
import daoImp.DienThoaiDAO;
import entity.DienThoai;

/**
 * Servlet implementation class DienThoaiController
 */
public class DienThoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EntityManegeFactoryUtil emfUtil;
	private DienThoaiDAO dienThoaiDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DienThoaiController() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		emfUtil = new EntityManegeFactoryUtil();
		dienThoaiDAO = new DienThoaiDAOImp(emfUtil.getEntityManager());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.emfUtil.close();
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "new":
			showDienThoaiForm(request, response);
			break;   
	    case "edit":
	    	showEditForm(request, response);
		case "delete":
			deleteDienThoai(request, response);
			break;
		default:
			listDienThoai(request, response);
			break;
		}
	}

	private void deleteDienThoai(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		dienThoaiDAO.Delete(id);
		response.sendRedirect("dienThoai");
		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		DienThoai dt = dienThoaiDAO.FindByID(id);
		request.setAttribute("editDienThoai", dt);
		request.getRequestDispatcher("views/dienThoai/edit.jsp").forward(request, response);
	}

	private void showDienThoaiForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/dienThoai/add.jsp").forward(request, response);
	}

	private void listDienThoai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		public DienThoai(String tendt, int namsx, String cauhinh, int mancc)
//		DienThoai dt = new DienThoai("Iphone 12", 2020, "A14 Bionic", 1);
//		dienThoaiDAO.Add(dt);
		request.setAttribute("listDienThoai", dienThoaiDAO.FindAll());
		request.getRequestDispatcher("views/dienThoai/list.jsp").forward(request, response);
		
	}

	private void updateDienThoai(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int maDienThoai = Integer.parseInt(request.getParameter("maDienThoai"));
		String tendt = request.getParameter("tenDienThoai");
		int namsx = Integer.parseInt(request.getParameter("namSanXuat"));
		String cauhinh = request.getParameter("cauHinh");
		int mancc = Integer.parseInt(request.getParameter("maNhaCungCap"));
		
		DienThoai dt = new DienThoai(maDienThoai,tendt, namsx, cauhinh, mancc);
		dienThoaiDAO.Update(dt);
		response.sendRedirect("dienThoai");
		
		
	}

	private void insertDienThoai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		String tendt = request.getParameter("tenDienThoai");
		int namsx = Integer.parseInt(request.getParameter("namSanXuat"));
		String cauhinh = request.getParameter("cauHinh");
		int mancc = Integer.parseInt(request.getParameter("maNhaCungCap"));
		
		DienThoai dt = new DienThoai(tendt, namsx, cauhinh, mancc);
		dienThoaiDAO.Add(dt);
		response.sendRedirect("dienThoai");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "insert":
			insertDienThoai(request, response);
			break;
		case "update":
			updateDienThoai(request, response);
			break;
		default:
			listDienThoai(request, response);
			break;
		}
		
	}

}
