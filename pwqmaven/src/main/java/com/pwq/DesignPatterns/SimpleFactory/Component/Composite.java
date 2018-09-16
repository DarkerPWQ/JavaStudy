package com.pwq.DesignPatterns.SimpleFactory.Component;

import java.util.ArrayList;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:55 2017/10/12
 * @Modified By：
 */
public class Composite extends Component {
    private String fileName;

    public Composite(String fileName) {
        this.fileName = fileName;
    }

    private ArrayList<Component> list = new ArrayList<>();
    @Override
    public void add(Component component) {
        this.list.add(component);
    }

    @Override
    public void remove(Component component) {
        this.list.remove(component);

    }

    @Override
    public Component get(int i) {
        return this.list.get(i);
    }

    @Override
    public void operation() {//容器操作
        System.out.println("我是文件夹"+this.fileName);
        for(Component c:list){
            c.operation();
        }
    }
}
