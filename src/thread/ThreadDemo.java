package thread;

/**
 * @Author: zzy
 * Date: 2018/11/12
 * Time: 14:52
 * Description:通过继承thread类来创建线程
 * 继承类必须重写run方法，改方法是线程的入口，他也必须调用start（）方法才能执行
 * 改方法尽管是一种多线程的实现方式 但是本质也是实现Runnable接口的一个实例
 * class Thread implements Runnable
 */
public class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
