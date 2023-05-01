package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import model.User;
import service.UserService;

/**
 * Servlet implementation class UserChangeAddressServlet
 */
@WebServlet("/user_changeaddress")
public class UserChangeAddressServlet extends HttpServlet {
	private UserService uService=new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserChangeAddressServlet() {
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
		
		User loginUser=(User) request.getSession().getAttribute("user");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		loginUser.setName(name);
		loginUser.setAddress(address);
		loginUser.setPhone(phone);
		loginUser.setCity(city);
		loginUser.setProvince(province);
		uService.updateUserAddress(loginUser);
		request.setAttribute("msg", "更新成功!");
		request.getRequestDispatcher("/user_center.jsp").forward(request, response);
	}

}
