package servlet;

import model.Goods;
import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/ConductCollectServlet")
public class ConductCollectServlet extends HttpServlet {
    UserService uService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("收集Servlet:Post");
        String strVisitTime =request.getParameter("visittime")+"秒";

        String goodname=request.getParameter("goodname");
        String typename=request.getParameter("typename");
        String username=request.getParameter("username");
        //获取当前系统时间
        Timestamp dateNow=new Timestamp(System.currentTimeMillis());
        Date reDate=new Date(System.currentTimeMillis());
        // 页面访问时间
        if(username!=null||username!="") {
            uService.userview(username,strVisitTime,goodname,typename,reDate);
        }
        else {
            uService.userview("游客",strVisitTime,goodname,typename,reDate);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
