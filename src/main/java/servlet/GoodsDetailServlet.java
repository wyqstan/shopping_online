package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import model.User;
import service.GoodsService;

/**
 * Servlet implementation class GoodsDetailServlet
 */
@WebServlet("/goods_detail")
public class GoodsDetailServlet extends HttpServlet {
	private GoodsService gService=new GoodsService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));//获取商品id
		Goods g=gService.getById(id);
		User user= (User) request.getSession().getAttribute("user");
		request.setAttribute("g", g);
		request.setAttribute("gn",g.getName());
		request.setAttribute("tn",g.getType().getName());
		request.getRequestDispatcher("/goods_detail.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
