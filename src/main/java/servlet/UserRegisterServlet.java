package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.codegen.bean.BeangenUtils;

import model.User;
import service.UserService;
import utils.convert;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {

	private UserService uService=new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		convert c=new convert();
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		name = c.toUTF_8(name);
		System.out.println(convert.isEncoding(name,"UTF-8"));
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		address=c.toUTF_8(address);
		User user=new User(username,email,password,name,phone,address);
		if(uService.Register(user)) {
			request.setAttribute("msg", "注册成功,请登录!");
			uService.addusersale(user.getId());
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "用户名或邮箱重复,请重新填写!");
			request.getRequestDispatcher("user_register.jsp").forward(request, response);
		}
		
		
	}

}
