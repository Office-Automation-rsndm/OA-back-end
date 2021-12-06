package service;

import bean.User;

import java.util.List;

public interface DepartmentService {
    List<Integer> getDepartmentIdList();
    List<User> getDepartmentPersonList(int id);
}
