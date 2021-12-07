package service.Impl;
import dao.UserMapper;
import bean.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class UserServiceImpl {
    //把数据持久层注入过来
    Reader r = Resources.getResourceAsReader("Mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(r);
    SqlSession sqlSession =  sqlSessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    public UserServiceImpl() throws IOException {
    }

    public User login(String userName,String passwd) throws Exception {
      User user =  mapper.loginRequest(userName,passwd);
        return user!=null ? user : null;
    }

    public void registerUser(User user) throws IOException {
        mapper.registerUser(user);
        sqlSession.commit();
    }

    public User selectFromId(int id){
        User user = mapper.selectFromId(id);
        return user;
    }
    void updatePwd(int id, String pwd) {
        mapper.updatePwd(id, pwd);
        sqlSession.commit();
    }
    void updateName(int id, String name) {
        mapper.updateName(id, name);
        sqlSession.commit();
    }
    void updateState(int id, String state) {
        mapper.updateState(id, state);
        sqlSession.commit();
    }
}