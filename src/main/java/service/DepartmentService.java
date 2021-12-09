package service;

import bean.Department;
import bean.User;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartmentList();
    List<User> getDepartmentPersonList(int id);
}
