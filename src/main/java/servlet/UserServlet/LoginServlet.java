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

@WebServlet(name = "LoginServlet", value = "/api/login")
public class LoginServlet extends HttpServlet {

    //把service注入过来
   UserServiceImpl userService= new UserServiceImpl();

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
            User user= userService.login(json.getString("username"),json.getString("password"));
            if (user!=null ){
                result.setStatus(1);
                result.setData(JSON.toJSON(user));
            }else {
                result.setStatus(-1);
                System.out.println(result.getStatus());
            }
            System.out.println(result);
            response.getWriter().write(objectMapper.writeValueAsString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }


//         response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
