package BeanFactory.SimpleFactory.FactoryMethod;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:15 2017/9/14
 * @Modified By：
 */
public class BmCar implements Car {
    @Override
    public void move() {
        System.out.println("宝马再跑");
    }
}
