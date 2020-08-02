import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Nina
 * DateTime 2020/8/2 14:38
 * Description 使用连接池管理连接
 * C3P0数据源，他是产生数据库连接的工厂，一个应用只需要一个数据源即可
 * 解决了数据库连接的频繁请求，释放导致的性能影响
 * 相比于DBCP数据源，性能更强
 */
public class DataSource {
    public static void main(String[] args) throws SQLException {
        //创建连接池实例
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            //设置驱动
            ds.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl("jdbc:mysql://47.112.230.94:3306/test_database?useSSL=true&serverTimezone=UTC");
        ds.setUser("user001");
        ds.setPassword("user001");
        //设置连接池的初始连接数
        ds.setInitialPoolSize(10);
        //最大连接数
        ds.setMaxPoolSize(20);
        //最小连接数
        ds.setMinPoolSize(2);
        //设置连接池的缓存Statement的最大数
        ds.setMaxStatements(180);

        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("select img_id,img_name from img_table");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2));
        }
    }
}
