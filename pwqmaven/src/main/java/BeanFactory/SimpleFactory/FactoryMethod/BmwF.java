package BeanFactory.SimpleFactory.FactoryMethod;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:13 2017/9/14
 * @Modified By：
 */
public class BmwF implements IFactory {
    @Override
    public Car create() {
        return new BmCar();

    }

    @Override
    public Wheel createW() {
        return new BmLz();
    }
}
