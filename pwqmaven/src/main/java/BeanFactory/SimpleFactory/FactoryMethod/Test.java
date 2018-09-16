package BeanFactory.SimpleFactory.FactoryMethod;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:21 2017/9/14
 * @Modified By：
 */
public class Test {
    public static void main(String[] args) {
        IFactory iFactory = new AdF();
        Car car = iFactory.create();
        car.move();
        Wheel wheel = iFactory.createW();
        wheel.houdu();
        iFactory = new BmwF();
        Car car1 = iFactory.create();
        car1.move();
        wheel = iFactory.createW();
        wheel.houdu();
    }
}
