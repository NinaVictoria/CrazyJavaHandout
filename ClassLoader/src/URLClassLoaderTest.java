import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * @author Nina
 * DateTime 2020/8/10 10:44
 * Description 使用URLClassLoader加载类
 */
public class URLClassLoaderTest {
    private static Connection conn;

    public static Connection getConn(String url, String user, String pass) throws Exception {
        if (conn == null) {
            //创建一个URL数组
            //file前缀代表从文件系统加载，http前缀代表从互联网通过http访问来加载，ftp前缀代表从互联网通过ftp访问来加载
            URL[] urls = {new URL("file:mysql-connector-java-5.1.30-bin.jar")};
            //以默认的ClassLoader作为父ClassLoader，创建URLClassLoader
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            //加载MySQL的JDBC驱动，并创建默认实例
            Driver driver = (Driver) myClassLoader.loadClass("com.mysql.jdbc.Driver").getConstructor().newInstance();
            //创建一个设置JDBC连接属性的Properties对象
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("pass", pass);
            //调用Driver对象的connect方法取得数据库连接
            conn = driver.connect(url, properties);
        }
        return conn;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConn("jdbc:mysql://localhost:3306/mysql", "root", "123456"));
    }
}
