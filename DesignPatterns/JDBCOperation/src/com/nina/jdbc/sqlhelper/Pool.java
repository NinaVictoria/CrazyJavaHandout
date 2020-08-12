package com.nina.jdbc.sqlhelper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author Nina
 * DateTime 2020/8/12 16:41
 * Description
 */
public abstract class Pool {
    public String propertiesName = ".\\JDBCOperation\\src\\com\\nina\\jdbc\\sqlhelper\\connection-INF.properties";
    private static Pool instance = null;  //定义唯一实例
    protected int maxConnect = 100; //最大连接数
    protected int normalConnect = 10; //保持连接数
    protected String driverName = null;   //驱动字符串
    protected Driver driver = null;   //驱动变量

    //私有构造函数，不允许外界访问
    protected Pool() {
        try {
            init();
            loadDriver(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化所有从配置文件读取的成员变量
    private void init() throws IOException {
        InputStream is = Pool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    //装载和注册JDBC驱动
    protected void loadDriver(String driverName) {
        try {
            driver = (Driver) Class.forName(driverName).getConstructor().newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动" + driverName);
        } catch (Exception e) {
            System.out.println("无法注册JDBC驱动" + driverName + ",错误:" + e);
        }
    }

    //创建连接池
    public abstract void createPool();

    /**
     * description: （单例模式）返回数据库连接池Pool的实例
     *
     * @return Pool
     */
    public static synchronized Pool getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        if (instance != null) {
            instance = (Pool) Class.forName("com.nina.jdbc.sqlhelper.Pool").getConstructor().newInstance();
        }
        return instance;
    }

    //获得一个可用的连接，如果没有，则创建一个连接，并且小于最大连接限制
    public abstract Connection getConnection();

    //获得一个连接，有时间限制
    public abstract Connection getConnection(Long time);

    //将连接对象返回连接池
    public abstract void freeConnection(Connection connection);

    //返回当前空闲的连接数
    public abstract int getFreeNum();

    //返回当前活动的连接数
    public abstract int getActiveNum();

    //撤销驱动
    protected synchronized void release() {
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销JDBC驱动：" + driver.getClass().getName());
        } catch (Exception e) {
            System.out.println("无法撤销JDBC驱动：" + driver.getClass().getName());
            e.printStackTrace();
        }
    }
}
