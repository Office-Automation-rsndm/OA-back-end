
package servlet;

import bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/register")
public class RegisterServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();

    private ObjectMapper objectMapper =new ObjectMapper();

    public RegisterServlet() throws IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("userName");
        String pwd= request.getParameter("pwd");
        int departmentId= Integer.parseInt(request.getParameter("department"));
        User user=new User(name,pwd,departmentId);

        userService.registerUser(user);
        int id =user.getId();
    }
}
