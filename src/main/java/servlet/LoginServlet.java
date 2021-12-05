package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.UserService;
import util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/api/login")
public class LoginServlet extends HttpServlet {

    //把service注入过来
    private UserService userService = new UserService();

    private ObjectMapper objectMapper =new ObjectMapper();

    private  Result result =new Result();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passwd =request.getParameter("password");

       //乱码
        response.setHeader("content-type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
       try {
           if (userService.login(userName, passwd)) {
               result.setStatus(200);
           }else{
               result.setStatus(-1);
           }
       }catch(Exception e){
               result.setStatus(-1);

       }
         response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
