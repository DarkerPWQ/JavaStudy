package com.pwq.MQ;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 17:55 2017/8/28
 * @Modified By：
 */
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class Send {
    private final static String QUEUE_NAME = "hello1";

    public static void main(String[] args) {
        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message = "hello world";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("[x] sent"+message+"");
            channel.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
