package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	private GoodsService gService=new GoodsService();
  
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取得条幅商品
		Map<String, Object> scrollGoods=gService.getScrollGoods();
		request.setAttribute("scroll",scrollGoods );
		//取得热销商品
		List<Map<String, Object>> hotlist=gService.getHotGoodsList();
		request.setAttribute("hotList", hotlist);
		//取得新品商品
		List<Map<String, Object>> newlist=gService.getNewGoodsList();
		request.setAttribute("newList", newlist);
		//跳转到index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
