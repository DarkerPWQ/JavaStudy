package com.pwq.mavenT;

/**
 * Created by BF100500 on 2017/4/6.
 */
public class InClassTest {
    private double radius=0;
    public static int count=1;
    public InClassTest(double radius){
        this.radius = radius;
    }
    public Draw getDraw(){
        return new Draw();
    }
    public void useDraw(){
        Draw draw = this.getDraw();
        draw.drawSahpe();
    }
    class Draw{
        private double radius=32;
        public void drawSahpe(){
            System.out.println(InClassTest.this.radius);
            System.out.println(count);
            System.out.println(radius);
        }
    }

    public static void main(String[] args) {
        InClassTest inClassTest = new InClassTest(3.2);
        inClassTest.useDraw();


    }

}
