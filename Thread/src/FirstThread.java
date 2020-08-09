/**
 * @author Nina
 * DateTime 2020/8/9 9:34
 * Description
 */

class FThread extends Thread {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }
}

public class FirstThread {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new FThread().start();
                new FThread().start();
            }
        }
    }
}
