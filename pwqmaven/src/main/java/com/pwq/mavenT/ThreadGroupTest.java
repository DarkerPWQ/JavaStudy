package com.pwq.mavenT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class ThreadGroupTest {
    private static final Logger log = LoggerFactory.getLogger(ThreadGroupTest.class);

    public static void main(String[] args) {
        log.debug("mian.thread.nameL{},   main.threadGroup.name:{}",Thread
                .currentThread().getName(),Thread.currentThread()
                .getThreadGroup().getName());
        Thread thread1 = new Thread("thread-1");
        log.debug("thread1.name:{},thread1.threadGroup.name:{}",
                thread1.getName(), thread1.getThreadGroup().getName());
        log.debug("threa1.name:{},threa1.isDaemon:{},threa1.priority:{}",
                thread1.getName(), thread1.isDaemon(), thread1.getPriority());
        Thread curThread = Thread.currentThread();
        log.debug(
                "curThread.name:{},curThread.isDaemon:{},curThread.priority:{}",
                curThread.getName(), curThread.isDaemon(),
                curThread.getPriority());
        Thread thread2 = new Thread();
        log.debug("threa2.name:{}", thread2.getName());

        ThreadGroup group1 = new ThreadGroup("ThreadGroup-1");
        // 输出:group1.parent.name:main,即group1的父线程组为main
        // ThreadGroup#public final ThreadGroup getParent() 返回线程组的父线程组
        log.debug("group1.parent.name:{}", group1.getParent().getName());
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        // 输出:mainGroup.parentOf(group1):true,group1.parentOf(group1),true
        // ThreadGroup#public final boolean parentOf(ThreadGroup g)
        // 判断该线程组是否为线程组参数或者是其祖先线程组
        // 从输出看,mainGroup是group1的parent,而传入原组,方法也返回true
        log.debug(
                "mainGroup.parentOf(group1):{},group1.parentOf(group1),{}",
                mainGroup.parentOf(group1), group1.parentOf(group1));
        // 从输出看mainGroup的父线程组为system.参考ThreadGroup的私有构造方法,可知system是一个系统线程组，其parent为null.即为初始线程组
        log.debug("mainGroup.parent.name:{}", mainGroup.getParent()
                .getName());
        GroupExampleThread get1 = new GroupExampleThread("GroupExampleThread-1");
        // 从Thread#start源码看，在启动线程后->会调用group.add(this),即只有在线程启动后,将才会将线程加入其所属线程组
        // 另外注意ThreadGroup#void add(Thread
        // t),即该方法只有默认访问权限,即包访问权限.所以应用程序无法调用该方法除非jdk lang包内的库
        get1.start();
        log.debug("group1.activeCount:{}", group1.activeCount());
        log.debug("mainGroup.activeCount:{}", get1.getThreadGroup()
                .activeCount());

        Thread[] mainGroupActiveThreads = new Thread[mainGroup.activeCount()];
        // ThreadGroup#public int enumerate(Thread list[])
        // 将此线程组即其子组中的所有活动线程复制到指定数组中.注应用程序可用使用activeCount方法获取数组大小的估计数.
        // 如果数组太小而无法保持所有线程,则忽略额外的线程
        // 可额外校验该方法的返回值是否严格小于参数list的长度
        // 因为此方法固有的竞争条件(源码实现也是取了一个Snapshot(syncrhonized)),建议仅用于信息目的
        mainGroup.enumerate(mainGroupActiveThreads);
        // 从输出看:1.主线程组包括两个活动线程,main和GroupExampleThread-1
        // 2.Thread#toString方法返回的信息是Thread[threadName,priority,groupName(如果其group不为null)]
        log.debug("mainGroupActiveThreads:{}",
                Arrays.toString(mainGroupActiveThreads));

        // Thread#public Thread(ThreadGroup group, String name) 指定线程组
        GroupExampleThread get2 = new GroupExampleThread(group1,
                "GroupExampleThread-2");
        // 通过调用start将get2加入group1
        get2.start();

        // 输出:group1.activeCount:1
        log.debug("group1.activeCount:{}", group1.activeCount());
        // 输出:mainGroup.activeCount:3,即其统计包括子线程的活动线程数目,因为group1为其子组
        log.debug("mainGroup.activeCount:{}", mainGroup.activeCount());








    }
    private static class GroupExampleThread extends Thread {
        public GroupExampleThread(String name) {
            super(name);
        }

        // 此构造方法指定了线程组
        public GroupExampleThread(ThreadGroup tg, String name) {
            super(tg, name);
        }

        @Override
        public void run() {
            log.debug("GroupExampleThread" + "[" + getName() + "]"
                    + " task begin.");

            // 用sleep模拟任务耗时
            try {
                sleep(5 * 1000);
            } catch (InterruptedException e) {
                log.debug("GroupExampleThread" + "[" + getName() + "]"
                        + " was interrutped");
            }

            log.debug("GroupExampleThread" + "[" + getName() + "]"
                    + " task end.");
        }
    }
}
