package com.pwq.Exception;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 16:42 2017/9/15
 * @Modified By：
 */
public class Controller {
    public static void main(String[] args) {
        try{
            Service s = new Service();
            s.name("pwq");
        }catch (ServiceException e){
//            e.printStackTrace();
//            System.out.println(e.getMessage());
        }
    }
    public void test(){
        Service s = new Service();
        s.name("pwq");
    }
}
