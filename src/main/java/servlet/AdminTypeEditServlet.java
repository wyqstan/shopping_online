package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import model.Type;
import service.TypeService;

/**
 * Servlet implementation class AdminTypeEditServlet
 */
@WebServlet("/admin/type_edit")
public class AdminTypeEditServlet extends HttpServlet {


	private TypeService tService=new TypeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTypeEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Type t=new Type();
		String name=request.getParameter("name");
		t.setName(name);
		tService.update(t);
		request.getRequestDispatcher("/admin/type_list").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
