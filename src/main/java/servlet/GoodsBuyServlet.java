package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import model.Order;
import service.GoodsService;

/**
 * Servlet implementation class GoodsBuyServlet
 */
@WebServlet("/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
	private GoodsService gService=new GoodsService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order o=null;
		if(request.getSession().getAttribute("order")!=null) {
			o=(Order) request.getSession().getAttribute("order");
		}else {
			o=new Order();
			request.getSession().setAttribute("order", o);
		}
		int goodsid=Integer.parseInt(request.getParameter("goodsid"));
		Goods goods=gService.getById(goodsid);
		if(goods.getStock()>0) {//库存>0时
			o.addGoods(goods);
			response.getWriter().print("ok");
		}else {
			response.getWriter().print("fail");
		}
	}

}
