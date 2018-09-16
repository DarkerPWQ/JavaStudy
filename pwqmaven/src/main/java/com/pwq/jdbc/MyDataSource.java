package com.pwq.jdbc;

import org.junit.Test;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:35 2017/8/11
 * @Modified By：
 */
public class MyDataSource implements DataSource {
    //链表 --- 实现栈结构
    private LinkedList<Connection> dataSources = new LinkedList<Connection>();

    //初始化连接数量
    public MyDataSource() {
        //一次性创建10个连接
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 10; i++) {
            try {
                System.out.println("创建中");
                //2、通过JDBC建立数据库连接
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pwq?characterEncoding=utf8&useSSL=true&serverTimezone=UTC","root","pwqmysql");
                //3、将连接加入连接池中
                dataSources.add(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        //取出连接池中一个连接
        final Connection conn = dataSources.removeFirst(); // 删除第一个连接返回
        return conn;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    //将连接放回连接池
    public void releaseConnection(Connection conn) {
        dataSources.add(conn);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
