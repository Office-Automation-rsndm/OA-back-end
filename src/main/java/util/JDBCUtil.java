package util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static{
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(new File("mysql.properties"));
            properties.load(fis);//以流的形式家在配置文件
            url = properties.getProperty("url");//通过key-value的方式那资源
            user = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
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
