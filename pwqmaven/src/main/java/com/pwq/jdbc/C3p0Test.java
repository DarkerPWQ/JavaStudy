package com.pwq.jdbc;



import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:09 2017/8/11
 * @Modified By：
 */
public class C3p0Test {
    public static void main(String[] args) throws SQLException {
        System.out.println("使用连接池................................");
        for (int i = 0; i < 20; i++) {
            long beginTime = System.currentTimeMillis();
            Connection conn = ConnectionManger.getInstance().getConnection();
            try {
                PreparedStatement pstmt = conn.prepareStatement("select * from user");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    // do nothing...
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println("第" + (i + 1) + "次执行花费时间为:" + (endTime - beginTime));
        }

        System.out.println("不使用连接池................................");
        for (int i = 0; i < 20; i++) {
            long beginTime = System.currentTimeMillis();
            MysqlDataSource mds = new MysqlDataSource();
            mds.setURL("jdbc:mysql://127.0.0.1:3306/pwq?characterEncoding=utf8&useSSL=true&serverTimezone=UTC");
            mds.setUser("root");
            mds.setPassword("pwqmysql");
            Connection conn = mds.getConnection();
            try {
                PreparedStatement pstmt = conn.prepareStatement("select * from user");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    // do nothing...
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("第" + (i + 1) + "次执行花费时间为:"
                    + (endTime - beginTime));
        }

    }
}
