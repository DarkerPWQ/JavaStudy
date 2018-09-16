package sync;

import java.util.concurrent.TimeUnit;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:24 2017/10/20
 * @Modified By：
 */
public class Test {
    private static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable(){
            public synchronized void run() {
                int i = 0;
                while (!stop) {
                    i++;
//                    System.out.println("jaja");

                }
            }
        });

        t.start();
//        t.join();
        long end = System.nanoTime();
        System.out.println(System.nanoTime()-end);
        System.out.println(end);

        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }
}
