package join;

/**
 * @author Nina
 * DateTime 2020/8/9 10:17
 * Description Join Thread
 */
public class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JoinThread("新线程");
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread joinThread = new JoinThread("被join的线程");
                joinThread.start();
                //main线程调用了join()方法，main线程必须等待joinThread线程执行完之后才会向下继续执行
                joinThread.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
