package BeanFactory.SimpleFactory.FactoryMethod;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:12 2017/9/14
 * @Modified By：
 */
public interface IFactory {
    public Car create();
    public Wheel createW();
}
