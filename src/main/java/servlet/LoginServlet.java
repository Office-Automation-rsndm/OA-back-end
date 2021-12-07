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

    public LoginServlet() throws IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passwd =request.getParameter("pwd");

        System.out.println(userName+passwd);
       //乱码
        try {
            userService.login(userName,passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setHeader("content-type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

//         response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
