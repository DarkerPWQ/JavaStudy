package com.pwq.DesignPatterns.SimpleFactory.RespPattern;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 13:51 2017/10/19
 * @Modified By：
 */
public class LeaveRequest {
    private String username;
    private int day;

    public LeaveRequest(String username, int day) {
        this.username = username;
        this.day = day;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
