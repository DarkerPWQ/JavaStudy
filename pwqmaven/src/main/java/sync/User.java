package sync;

import java.io.Serializable;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 21:39 2017/11/22
 * @Modified By：
 */
public class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;

    private  String username;
    private transient String passwd;

    @Override
    public int hashCode() {
        return 12138;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
