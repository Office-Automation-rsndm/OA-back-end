package dao;

import bean.Department;
import bean.User;

import java.util.List;

public interface DepartmentMapper {
    List<User> getDepartmentPersonList(int id);
    List<Department> getDepartmentList();
}
