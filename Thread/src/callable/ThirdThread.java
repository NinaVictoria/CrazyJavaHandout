package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Nina
 * DateTime 2020/8/9 9:51
 * Description
 */
public class ThirdThread {
    public static void main(String[] args) {
        //创建Callable对象
        ThirdThread thirdThread = new ThirdThread();
        //先使用Lambda表达式创建Callable<Integer>对象
        //使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值:" + i);
            if (i == 20) {
                new Thread(task, "有返回值得线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值:" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
