package com.pwq.mavenT;

import java.sql.*;

/**
 * Created by BF100500 on 2017/3/29.
 */
public class JDBCtest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        try{
            //1：加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2通过驱动管理类获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                    "pwq","root","pwqmysql");
            //定义sql语言？表示占位符
            String sql = "select * from user where username = ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号，从1开始
            preparedStatement.setString(1,"文强");
            //向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历查询结果集
            while(resultSet.next()) {
                System.out.println();
            }
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                //释放资源
            if(resultSet!=null){
                try{
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }



        }

    }
}
