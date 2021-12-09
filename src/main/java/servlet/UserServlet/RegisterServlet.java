
package servlet.UserServlet;

import bean.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.Impl.UserServiceImpl;
import service.UserService;
import util.Result;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/api/register")
public class RegisterServlet extends HttpServlet {

UserServiceImpl userService=new UserServiceImpl();
    private ObjectMapper objectMapper =new ObjectMapper();
Result result =new Result();
    public RegisterServlet() throws IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("content-type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            JSONObject json= JSONObject.parseObject(sb.toString());
            System.out.println(json);

            String name= json.getString("userName");
            String pwd=  json.getString("password");
            int departmentId= Integer.parseInt(json.getString("department"));
            User user=new User(name,pwd,departmentId);
            System.out.println(user);
            userService.registerUser(user);
           result.setStatus(1);
            response.getWriter().write(objectMapper.writeValueAsString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
