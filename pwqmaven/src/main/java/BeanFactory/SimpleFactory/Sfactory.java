package BeanFactory.SimpleFactory;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 17:58 2017/9/13
 * @Modified By：
 */
public class Sfactory {
    public Car create(String name){
        Car car = null;
        if("dz".equals(name)){
            car = createDz();
        }else if("bm".equals(name)){
            car = createBM();
        }else{
            car = createLL();
        }
        return car;
    }

    public Car createDz(){
        return new DZcar();
    }
    public Car createBM(){
        return new BMWCar();
    }
    public Car createLL(){
        return new LLCar();
    }

}
