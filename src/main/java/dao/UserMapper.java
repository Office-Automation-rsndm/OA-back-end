package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User loginRequest(@Param("name") String name,@Param("pwd") String pwd);
}

