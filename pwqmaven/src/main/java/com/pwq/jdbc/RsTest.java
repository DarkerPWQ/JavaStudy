package com.pwq.jdbc;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pwq on 2017/9/24.
 */
public class RsTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动类
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?serverTimezone=UTC&characterEncoding=utf8&useSSL=true","root","pwqmysql");
            statement = connection.createStatement();
            String sql  = "select * from pwq";
            ResultSet rs = statement.executeQuery(sql);
//            while(rs.next()){
//                System.out.println(rs.getString("name"));
//                System.out.println(rs.getString("place"));
//            }
//            rs.close();
            List<PwqP> list = transPo(rs,PwqP.class);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e ){
            e.printStackTrace();
        }finally {
            //关闭资源
            if(null !=statement){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    if(null!=connection){
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static <T> List<T> transPo(ResultSet rs,Class<T> clasz) throws SQLException, IllegalAccessException, InstantiationException {
        List<T> list = new ArrayList<>();
        ResultSetMetaData rsma = rs.getMetaData();//得到结果集的结构数据（列数与列名等）
        int colCount = rsma.getColumnCount();
        Field[] fields = clasz.getDeclaredFields();
        while(rs.next()){
            T ins = clasz.newInstance();
                for(int i = 1;i<colCount+1;i++){
                    for(Field f:fields){
                        String colName = rsma.getColumnName(i);
                        if(f.getName().equalsIgnoreCase(colName.replace("_",""))){
                            f.setAccessible(true);
                            f.set(ins,rs.getObject(i));
                            break;
                    }
                }

            }
            list.add(ins);

        }
        return list;

    }

}
