package servlet;

import model.Page;
import model.UserRecord;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/IP_list")
public class AdminIPListServlet extends HttpServlet {
    UserService uService=new UserService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo=1;
        if(request.getParameter("pageNo")!=null) {
            pageNo=Integer.parseInt(request.getParameter("pageNo"));
        }
        Page p=uService.get_IPList(pageNo);
        request.setAttribute("p", p);
        request.getRequestDispatcher("/admin/IP_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
