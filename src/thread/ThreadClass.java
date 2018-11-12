package thread;

/**
 * @Author: zzy
 * Date: 2018/11/12
 * Time: 16:17
 * Description:测试
 */
public class ThreadClass {
    public static void main(String[] args) {
        Runnable hello=new DisplayMessage("hello");
        Thread thread1 = new Thread(hello);
        //将该线程标记为守护线程或用户线程。
        thread1.setDaemon(true);
        thread1.setName("hello");
        System.out.println("Starting hello thread");
        thread1.start();

        Runnable bye=new DisplayMessage("bye");
        Thread thread2=new Thread(bye);
        //更改线程的优先级
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        System.out.println("Strating bye thread");
        thread2.start();

        System.out.println("Strating thread3");
        Thread thread3 = new GuessNumber(27);
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interupted");
        }
        System.out.println("Starting thread4...");
        Thread thread4 = new GuessNumber(75);

        thread4.start();
        System.out.println("main() is ending...");
    }
}
