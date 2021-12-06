package dao;

import bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User loginRequest(@Param("name") String name,@Param("pwd") String pwd);
    void registerUser(User user);
    User selectFromId(int id);
    void updatePwd(int id, String pwd);
    void updateName(int id, String name);
    void updateState(int id, String State);
}


