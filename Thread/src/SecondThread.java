import javax.print.attribute.standard.RequestingUserName;

/**
 * @author Nina
 * DateTime 2020/8/9 9:34
 * Description
 */

class SThread implements Runnable {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

public class SecondThread {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                SThread st = new SThread();
                new Thread(st, "new Thread 1").start();
                new Thread(st, "new Thread 2").start();
            }
        }
    }
}
