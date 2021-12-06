package service;
import dao.UserMapper;
import entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    //把数据持久层 注入过来



    public boolean login(String userName,String passwd) throws Exception {
        UserMapper mapper=InitMapper.initMapper();
        System.out.println(mapper.loginRequest("oyy","123"));
        return true;
    }




}
