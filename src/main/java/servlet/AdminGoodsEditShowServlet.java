package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import service.GoodsService;

/**
 * Servlet implementation class AdminGoodsEditShowServlet
 */
@WebServlet("/admin/goods_editshow")
public class AdminGoodsEditShowServlet extends HttpServlet {

	private GoodsService gService=new GoodsService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGoodsEditShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Goods g=gService.getById(id);
		request.setAttribute("g", g);
		request.getRequestDispatcher("/admin/goods_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
