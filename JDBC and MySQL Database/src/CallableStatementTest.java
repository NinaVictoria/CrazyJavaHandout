import java.sql.*;

/**
 * @author Nina
 * DateTime 2020/8/2 9:53
 * Description 使用CallableStatement调用存储过程
 */
public class CallableStatementTest {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://47.112.230.94:3306/test_database?useSSL=true&serverTimezone=UTC", "user001", "user001");
                //创建CallableStatement对象
                CallableStatement callableStatement = connection.prepareCall("{call add_pro(?,?,?)}")
        ) {
            //设置输入参数
            callableStatement.setInt(1, 5);
            callableStatement.setInt(2, 15);
            //设置输出参数类型
            callableStatement.registerOutParameter(3, Types.INTEGER);
            //调用存储过程
            callableStatement.execute();
            //取出输出参数的值
            System.out.println(callableStatement.getInt(3));
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
    }
}
