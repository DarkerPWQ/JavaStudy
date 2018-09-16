package loggTest;

import java.util.logging.Logger;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:40 2017/12/27
 * @Modified By：
 */
public class JdkLogTest {
    private static final Logger logger= Logger.getLogger(JdkLogTest.class.getName());
    public static void main(String[] args) {
        logger.info("jdk logging info: a msg");
        System.out.println(System.getProperty("java.util.logging.LogManager"));
    }
}
