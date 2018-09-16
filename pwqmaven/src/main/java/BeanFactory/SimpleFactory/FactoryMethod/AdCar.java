package BeanFactory.SimpleFactory.FactoryMethod;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:20 2017/9/14
 * @Modified By：
 */
public class AdCar implements Car {
    @Override
    public void move() {
        System.out.println("奥迪再跑");
    }
}
