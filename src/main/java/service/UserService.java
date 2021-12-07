package service;
import dao.UserMapper;
import bean.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class UserService {

    //把数据持久层 注入过来
    Reader r = Resources.getResourceAsReader("Mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(r);
    SqlSession sqlSession =  sqlSessionFactory.openSession();
    UserMapper mapper= sqlSession.getMapper(UserMapper.class);
    public UserService() throws IOException { }




    public boolean login(String userName,String passwd) throws Exception {

        System.out.println(mapper.loginRequest(userName,passwd));
        User user= mapper.loginRequest(userName, passwd);
        return user!=null ? true : false;
    }

    public void registerUser(User user) throws IOException {
        mapper.registerUser(user);
        sqlSession.commit();
    }

    public User selectFromId(int id){
        User user=mapper.selectFromId(id);
      return  user!=null ? user : null;
    }

}
