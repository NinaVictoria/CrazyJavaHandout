import java.sql.*;

/**
 * @author Nina
 * DateTime 2020/8/1 18:25
 * Description JDBC
 */
public class JDBCConnectionTest {
    public static void main(String[] args) {
        //新版的JDBC驱动可以通过SPI自动注册驱动类，不需要下方代码
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://47.112.230.94:3306/test_database?useSSL=true&serverTimezone=UTC", "user001", "user001");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * from users")
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "   " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }

    }
}
