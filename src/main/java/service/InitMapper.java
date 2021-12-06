package service;

import dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class InitMapper {
    public static UserMapper initMapper() throws IOException {
        Reader r = Resources.getResourceAsReader("Mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(r);
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        return sqlSession.getMapper(UserMapper.class);
    }
}
