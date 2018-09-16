package BeanFactory.SimpleFactory.FactoryMethod;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:21 2017/9/14
 * @Modified By：
 */
public class AdF implements IFactory {
    @Override
    public Car create() {
        return new AdCar();
    }

    @Override
    public Wheel createW() {
        return new Adlz();
    }
}
