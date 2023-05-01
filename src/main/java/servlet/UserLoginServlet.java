package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserRecord;
import service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user_login")
public class UserLoginServlet extends HttpServlet {
	
    private UserService uService=new UserService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		String ue=request.getParameter("ue");
		String password=request.getParameter("password");
		User user=uService.login(ue, password);
		if(user==null) {
			request.setAttribute("failMsg", "用户名、邮箱或者密码错误,请重新登录!");
			request.getRequestDispatcher("/user_login.jsp").forward(request, response);
		}else {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			String ip;
			if (request.getHeader("x-forwarded-for") == null) {
				ip=request.getRemoteAddr();
			}
			else ip=request.getHeader("x-forwarded-for");
			//获取当前系统时间
			Timestamp dateNow=new Timestamp(System.currentTimeMillis());
			Date reDate=new Date(System.currentTimeMillis());
			UserRecord userRecord=new UserRecord(ue,ip,reDate,"登录");
			uService.login_record(userRecord);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("un", user.getUsername());
			request.getRequestDispatcher("/user_center.jsp").forward(request, response);
		}
	}

}
