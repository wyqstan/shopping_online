package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

/**
 * Servlet implementation class UserChangePwd
 */
@WebServlet("/user_changepwd")
public class UserChangePwdServlet extends HttpServlet {
	private UserService uService=new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserChangePwdServlet() {
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
		String password=request.getParameter("password");
		String newPwd=request.getParameter("newPassword");
		User u=(User) request.getSession().getAttribute("user");
		if(password.equals(u.getPassword())) {
			u.setPassword(newPwd);
			uService.updatePwd(u);
			request.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("/user_center.jsp").forward(request, response);
		}else {
			request.setAttribute("failMsg", "修改失败,原密码错误,请重新输入");
			request.getRequestDispatcher("/user_center.jsp").forward(request, response);
		}
	}

}
