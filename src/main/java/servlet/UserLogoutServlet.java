package servlet;

import model.User;
import model.UserRecord;
import service.UserService;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogout
 */
@WebServlet("/user_logout")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService uService=new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ip;
		User user=(User)request.getSession().getAttribute("user");
		String username=user.getUsername();
		if (request.getHeader("x-forwarded-for") == null) {
			ip=request.getRemoteAddr();
		}
		else ip=request.getHeader("x-forwarded-for");
		//获取当前系统时间
		Timestamp dateNow=new Timestamp(System.currentTimeMillis());
		Date reDate=new Date(System.currentTimeMillis());
		UserRecord userRecord=new UserRecord(username,ip,reDate,"注销");
		uService.login_record(userRecord);
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("un");
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
