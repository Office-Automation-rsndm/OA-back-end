package util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String url="jdbc:mysql://localhost:3306/rsndm?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT";
    private static String user="root";
    private static String password="123456";
    private static String driver="com.mysql.jdbc.Driver";

    static{
        try {
            Properties properties = new Properties();
//            FileInputStream fis = new FileInputStream(new File("resources/mysql.properties"));
//            properties.load(fis);//以流的形式家在配置文件
//            url = properties.getProperty("url");//通过key-value的方式那资源
//            user = properties.getProperty("username");
//            password = properties.getProperty("password");
//            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {

            e.getMessage();
        }

    }
    public static Connection getConn() throws Exception{

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement,
                             Connection connection){

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if(preparedStatement != null ){
                preparedStatement.close();
            }
            if(connection != null ){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
