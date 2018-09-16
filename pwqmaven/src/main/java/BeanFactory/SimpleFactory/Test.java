package BeanFactory.SimpleFactory;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 18:08 2017/9/13
 * @Modified By：
 */
public class Test {
    public static void main(String[] args) {
        //简单工厂的模拟
        Sfactory sfactory = new Sfactory();
        Car car = sfactory.create("dz");
        car.name();
        Car car1 = sfactory.create("bm");
        car1.name();
    }
}
