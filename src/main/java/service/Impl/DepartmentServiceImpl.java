package service.Impl;

import bean.User;
import dao.DepartmentMapper;
import dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class DepartmentServiceImpl {
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

    List<Integer> getDepartmentIdList() {
        return mapper.getDepartmentIdList();
    }
    List<User> getDepartmentPersonList(int id) {
        return mapper.getDepartmentPersonList(id);
    }
}
