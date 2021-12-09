package servlet.DepartmentServlet;

import bean.Department;
import bean.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.Impl.DepartmentServiceImpl;
import service.Impl.UserServiceImpl;
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
import java.util.List;

@WebServlet(name = "GetUserServlet",value = "/api/getUser")
public class GetUserServlet extends HttpServlet {
    DepartmentServiceImpl departmentService=new DepartmentServiceImpl();
    UserServiceImpl userService=new UserServiceImpl();
    Result<Object> result =new Result<Object>();
    ObjectMapper objectMapper =new ObjectMapper();


    public GetUserServlet() throws IOException {
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
            int id = Integer.parseInt(json.getString("id"));
            System.out.println(id);
            List<User> list=  departmentService.getDepartmentPersonList(id);
            result.setStatus(1);
            result.setData(JSON.toJSON(list));
            System.out.println(list);
            response.getWriter().write(objectMapper.writeValueAsString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
