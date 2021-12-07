package service;
import dao.UserMapper;
import bean.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public interface UserService {
    boolean login(String userName, String passwd);
    void registerUser(User user);
    User selectFromId(int id);
    void updatePwd(int id, String pwd);
    void updateName(int id, String name);
    void updateState(int id, String state);
}
