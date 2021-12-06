package servlet;

import bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectFromIdServlet")
public class SelectFromIdServlet extends HttpServlet {
    private UserService userService = new UserService();

    private ObjectMapper objectMapper =new ObjectMapper();

    public SelectFromIdServlet() throws IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id =Integer.parseInt(request.getParameter("id"));
    User user=userService.selectFromId(id);
    }
}
