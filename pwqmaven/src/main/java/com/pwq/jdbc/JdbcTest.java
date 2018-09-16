package com.pwq.jdbc;

import org.apache.ibatis.jdbc.SQL;

import java.sql.*;
import java.util.*;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:32 2017/8/8
 * @Modified By：
 */
public class JdbcTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://10.0.20.108:3306/CREDIT_SPIDER?characterEncoding=utf8&useSSL=true","baofoo","mandao@64//");
            conn.setAutoCommit(false);//开启事务
            long start = System.currentTimeMillis();
            stmt = conn.createStatement();
            Map<String,String> map = new HashMap<>();
            Set<String> set = new HashSet<>();
//            for(int i = 0;i<2000000;i++){
//                stmt.addBatch("insert into user (username,birthday,sex,address) values('pwq"+i+"','1994-01-05','男','安徽')");
//            }
//            stmt.executeBatch();
//            stmt.execute("insert into user (username,birthday,sex,address) values ('pwq','1994-01-05','男','')");
            String sql = "select * from t_dir_mobile_h";
            ResultSet resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String tele_code = resultSet.getString("tele_code");
                String city_name = resultSet.getString("city_name");
                if(!set.contains(city_name)){
                    set.add(city_name);
                    map.put(id,tele_code);
                }


//                System.out.println(resultSet.getString("username"));//可以通过字段
//                System.out.println(resultSet.getString("birthday"));
//                System.out.println("-----------");
//                System.out.println(resultSet.getString("address"));
//                if(null==resultSet.getString("address")){
//                    System.out.println("未设置的值返回结果是null");
//                }
//                if(resultSet.getString("address").equals("")){
//                    System.out.println("未设置的值返回结果是kong");
//                }
            }
            System.out.println(set.size());
            //添加
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                String val = (String)entry.getValue();
                stmt.addBatch("update t_dir_mobile_h set unique_code='"+val+"' where id = "+key+"");
            }
            stmt.executeBatch();
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("插入2w调数据耗时："+(end-start));

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt!=null){
                    stmt.close();
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
