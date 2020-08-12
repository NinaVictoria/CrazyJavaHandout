package com.nina.jdbc.sqlhelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * @author Nina
 * DateTime 2020/8/12 17:09
 * Description 数据库连接池管理类
 */
public final class DBConnectionPool extends Pool {
    private int checkedOut; //正在使用的连接数
    private Vector<Connection> freeConnections = new Vector<>(); //存放产生的连接对象
    private String username = null; //用户名
    private String password = null; //密码
    private String url = null; //连接字符串
    private static int numFree = 0; //空闲连接数
    private static int numActive = 0; //活动连接数
    private static DBConnectionPool pool = null; //连接池实例变量

    //产生连接池
    public static synchronized DBConnectionPool getInstance() {
        if (pool == null) {
            pool = new DBConnectionPool();
        }
        return pool;
    }

    private DBConnectionPool() {
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection c = newConnection();
                if (c != null) {
                    freeConnections.addElement(c);
                    numFree++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        InputStream inputStream = DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(inputStream);
        this.username = p.getProperty("username");
        this.password = p.getProperty("password");
        this.url = p.getProperty("url");
    }

    @Override
    public void createPool() {
        pool = new DBConnectionPool();
        if (pool != null) {
            System.out.println("创建连接池成功");
        } else {
            System.out.println("创建连接池失败");
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        if (freeConnections.size() > 0) {
            numFree--;
            connection = (Connection) freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (connection.isClosed()) {
                    System.out.println("从连接池删除一个无效连接");
                    connection = getConnection();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (maxConnect == 0 || checkedOut < maxConnect) {
            connection = newConnection();
        }
        if (connection != null) {
            checkedOut++;
        }
        numActive++;
        return connection;
    }

    @Override
    public synchronized Connection getConnection(Long time) {
        long startTime = new Date().getTime();
        Connection connection;
        while ((connection = getConnection()) == null) {
            try {
                wait(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((new Date().getTime() - startTime) >= time) {
                return null;
            }
        }
        return connection;
    }

    @Override
    public void freeConnection(Connection connection) {
        freeConnections.addElement(connection);
        numFree++;
        numActive--;
        checkedOut--;
        notifyAll();
    }

    @Override
    public int getFreeNum() {
        return numFree;
    }

    @Override
    public int getActiveNum() {
        return numActive;
    }

    private Connection newConnection() {
        Connection connection = null;
        try {
            if (username == null) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
            System.out.println("连接池创建一个新的连接");
        } catch (SQLException e) {
            System.out.println("无法创建这个URL的连接" + url);
            return null;
        }
        return connection;
    }

    @Override
    protected synchronized void release() {
        try {
            Enumeration allConnections = freeConnections.elements();
            while (allConnections.hasMoreElements()) {
                Connection connection = (Connection) allConnections.nextElement();
                try {
                    connection.close();
                    numFree--;
                } catch (SQLException e) {
                    System.out.println("无法关闭连接池的连接");
                    e.printStackTrace();
                }
            }
            freeConnections.removeAllElements();
            numActive = 0;
        } finally {
            super.release();
        }
    }
}
