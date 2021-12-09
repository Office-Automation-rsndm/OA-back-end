package service.Impl;

import bean.Department;
import bean.User;
import dao.DepartmentMapper;
import dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.DepartmentService;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    Reader r;
    {
        try {
            r = Resources.getResourceAsReader("Mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(r);
    SqlSession sqlSession =  sqlSessionFactory.openSession();
    DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

    public List<Department> getDepartmentList() {
        return mapper.getDepartmentList();
    }
    public List<User> getDepartmentPersonList(int id) {
        return mapper.getDepartmentPersonList(id);
    }
}
