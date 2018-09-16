package com.pwq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:18 2017/8/8
 * @Modified By：
 */
public class QueryTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pwq?characterEncoding=utf8&useSSL=true&serverTimezone=UTC","root","pwqmysql");
            String sql = "insert into user (username,birthday,sex,address) values (?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,"杜明强");
            pstm.setString(2,"2015-10-07");
            pstm.setString(3,"男");
            pstm.setString(4,"上海");
            pstm.executeUpdate();


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm!=null){
                    pstm.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try{
                    if(conn!=null){
                        conn.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }

            }
        }
    }
}
