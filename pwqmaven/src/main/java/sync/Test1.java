package sync;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:12 2017/10/20
 * @Modified By：
 */
public class Test1 {
    private static boolean ready = false;
    private static int number = 0;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            int j = 0;
            while (!ready) {
//                Thread.yield(); //交出CPU让其它线程工作
                j++;
                System.out.println(j);
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);

        number = 42;
        ready = true;
    }

}
