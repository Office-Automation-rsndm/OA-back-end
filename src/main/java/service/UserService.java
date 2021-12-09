package service;

import bean.User;

import java.io.IOException;

public interface UserService {
    User login(String userName, String passwd);
    void registerUser(User user) throws IOException;
    User selectFromId(int id);
    void updatePwd(int id, String pwd);
    void updateName(int id, String name);
    void updateState(int id, String state);
}