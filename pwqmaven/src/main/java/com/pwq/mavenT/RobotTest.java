package com.pwq.mavenT;

import com.pwq.utils.Base64;
import org.junit.*;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 13:45 2017/7/27
 * @Modified By：
 */
public class RobotTest {
    public static void main(String[] args)throws Exception {
        Robot robot =new Robot();
        robot.delay(500);
        robot.mouseMove(415,1060);
        robot.delay(500);
        robot.mousePress(KeyEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
//        try {
//            Robot robot = new Robot();
//            robot.delay(2000);
//            //鼠标移动到坐标(635,454)
//            RobotTest.clickMouse(robot, 766, 355, 500);
//            int[] keys = {
//                    KeyEvent.VK_W,KeyEvent.VK_A,
//                    KeyEvent.VK_N,KeyEvent.VK_G,
//                    KeyEvent.VK_T,KeyEvent.VK_I,
//                    KeyEvent.VK_A,KeyEvent.VK_N,
//                    KeyEvent.VK_Z,KeyEvent.VK_E};
//            robot.delay(500);
//            robot.delay(500);
//            RobotTest.pressKey(robot,keys,500);
//        } catch (AWTException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }


    }
    /**
     * @Author: WenqiangPu
     * @Description:
     * @param robot
     * @param x
     * @param y
     * @param delay
     * @return:
     * @Date: 14:13 2017/7/27
     */
    public static void clickMouse(Robot robot,int x,int y,int delay){

//        robot.mouseMove(x, y);
//        robot.delay(500);
//        robot.mousePress(InputEvent.BUTTON1_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_MASK);
//        robot.delay(delay);
    }

    @Test
    public  void test() throws Exception{
//        OutputStream;
//        ByteArrayOutputStream;
//        ByteArrayInputStream;
//        FileInputStream;
//        CharArrayWriter;
//        StringWriter;
//        InputStreamReader;
//        OutputStreamWriter
//        FileOutputStream
        Robot robot = new Robot();
        robot.setAutoDelay(1000);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(d);
        Rectangle screenRect = new Rectangle(1542,264,65,64);
        BufferedImage bufferedImage = robot.createScreenCapture(screenRect);
        File file = new File("screenRect.png");
        ImageIO.write(bufferedImage,"png",file);
        robot.mouseMove(1423,237);
        robot.delay(500);
        System.out.println("单机");
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//qq
        robot.mouseMove(1506,1064);
        robot.delay(500);
        System.out.println("单机");
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);

        //鼠标右键
        System.out.println("右击");
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);

        //按下ESC，退出右键状态
        System.out.println("按下ESC");
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        //滚动鼠标滚轴
        System.out.println("滚轴");
        robot.mouseWheel(5);

        //按下Alt+TAB键（切换桌面窗口）
        robot.keyPress(KeyEvent.VK_ALT);
        for(int i=1;i<=2;i++)
        {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyRelease(KeyEvent.VK_ALT);
    }
    /**
     * @Author: WenqiangPu
     * @Description: 键盘操作
     * @param robot
     * @param keys
     * @param delay
     * @return:
     * @Date: 14:31 2017/7/27
     */
    public static void pressKey(Robot robot,int[] keys,int delay){
        for(int i =0;i<keys.length;i++){
            robot.keyPress(keys[i]);
            robot.keyRelease(keys[i]);
            robot.delay(500);
        }
        robot.delay(500);

    }
    @Test
    public void test2() throws Exception{
        Robot robot =new Robot();
        robot.delay(500);
        robot.mouseMove(415,1060);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);



    }
}
