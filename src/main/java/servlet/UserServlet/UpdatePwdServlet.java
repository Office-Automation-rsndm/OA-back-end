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

@WebServlet(name = "UpdatePwdServlet",value = "/api/updatePwd")
public class UpdatePwdServlet extends HttpServlet {

    UserServiceImpl userService= new UserServiceImpl();

    private ObjectMapper objectMapper =new ObjectMapper();

    private Result result =new Result();


    public UpdatePwdServlet() throws IOException {
    }

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

            String newPwd=json.getString("newPassword");
            int id = Integer.parseInt(json.getString("id"));
            userService.updatePwd(id,newPwd);
            User user= userService.selectFromId(id);
            result.setData(JSON.toJSON(user));
            result.setStatus(1);
            System.out.println(result.getData());
            response.getWriter().write(objectMapper.writeValueAsString(result));

        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
