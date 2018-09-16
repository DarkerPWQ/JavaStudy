package com.pwq.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:10 2017/8/11
 * @Modified By：
 */
public class ConnectionManger {
    //使用单例模式创建数据库连接池
    private static ConnectionManger instance;
    private static ComboPooledDataSource dataSource;
    private ConnectionManger(){
        dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("pwqmysql");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/pwq?characterEncoding=utf8&useSSL=true&serverTimezone=UTC");
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();

        }
        dataSource.setInitialPoolSize(5); //初始化连接数
        dataSource.setMinPoolSize(1);//最小连接数
        dataSource.setMaxPoolSize(10);//最大连接数
        dataSource.setMaxStatements(50);//最长等待时间
        dataSource.setMaxIdleTime(60);//最大空闲时间，单位毫秒
    }
    public static final ConnectionManger getInstance(){
        if(instance==null){
            instance = new ConnectionManger();
        }
        return instance;
    }
    public synchronized final Connection getConnection(){
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;

    }
}
