package service;

import bean.User;

public interface UserService {
    boolean login(String userName, String passwd);
    void registerUser(User user);
    User selectFromId(int id);
    void updatePwd(int id, String pwd);
    void updateName(int id, String name);
    void updateState(int id, String State);
}