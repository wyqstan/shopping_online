package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.codegen.bean.BeangenUtils;

import service.GoodsService;
import service.OrderService;
import service.TypeService;
import service.UserService;

/**
 * Servlet implementation class OrderConfirmServlet
 */
@WebServlet("/order_confirm")
public class OrderConfirmServlet extends HttpServlet {
	
	private UserService userService=new UserService();
	private TypeService tService=new TypeService();
	private OrderService oService=new OrderService();
    private GoodsService gService=new GoodsService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderConfirmServlet() {
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
		Order o=(Order) request.getSession().getAttribute("order");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		o.setName(name);
		o.setAddress(address);
		o.setPhone(phone);
		o.setDatetime(new Date());
		o.setStatus(2);
		o.setCity(city);
		o.setProvince(province);
		o.setUser((User) request.getSession().getAttribute("user"));
		Map<Integer,Orderitem> map=o.getItemMap();
		int typeid=-1;
		int amount;
		int userid=o.getUser().getId();
		for(Orderitem orderitem: map.values()){
			Goods g=orderitem.getGoods();
			int sales=g.getSales();
			Type t=g.getType();
			sales+=orderitem.getAmount();
			String typename=t.getName();
			gService.updateSales(g.getId(),sales);
			typeid=g.getType().getId();
			amount=orderitem.getAmount();
			int current=userService.selectusersale(typename,userid);
			System.out.println(current);
			current+=amount;
			userService.updateusersale(userid,typename,current);
			amount+=t.getSales();
			tService.update_sale(typeid,amount);
		}
		double total_price=o.getTotal();
		userService.updateTotalPrice(userid,total_price);
		oService.addOrder(o);
		request.getSession().removeAttribute("order");
		request.setAttribute("msg", "订单支付成功!");
		request.getRequestDispatcher("/order_success.jsp").forward(request, response);
	}

}
