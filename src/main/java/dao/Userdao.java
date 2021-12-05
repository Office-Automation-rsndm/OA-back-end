package dao;

import util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Userdao {
//11

    public int login(String userName,String passwd) throws Exception {
        int flag = 0;
        String sql="select user_id from user where user_name="+userName+"user_pwd="+passwd;
        Connection con=JDBCUtil.getConn();
        Statement statement =con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            flag=1;
        }
        return flag;

    }


}
