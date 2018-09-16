package com.pwq.DesignPatterns.SimpleFactory.Component;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:52 2017/10/12
 * @Modified By：
 */
public class Leaf extends Component {
    private String filename;

    public Leaf(String filename) {
        this.filename = filename;
    }

    @Override
    public void add(Component component) {
        System.out.println("已经是文件，无法进行添加");
    }

    @Override
    public void remove(Component component) {
        System.out.println("已经是文件，无法进行删除");
    }

    @Override
    public Component get(int i) {
        System.out.println("已经是文件，无法进行提取");
        return null;
    }

    @Override
    public void operation() {
        System.out.println("我是文件"+this.filename);
    }
}
