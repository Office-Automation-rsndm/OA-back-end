package dao;

import bean.User;

import java.util.List;

public interface DepartmentMapper {
    List<Integer> getDepartmentIdList();
    List<User> getDepartmentPersonList(int id);
}
