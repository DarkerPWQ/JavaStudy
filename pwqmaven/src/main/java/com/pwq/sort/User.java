package com.pwq.sort;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 20:13 2017/8/2
 * @Modified By：
 */
public class User implements Comparable<User>{
    private String name;
    private Integer order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int compareTo(User o) {
        if(this.getOrder()<o.getOrder()){
            return -1;
        }else {
            return 1;
        }
    }
}
