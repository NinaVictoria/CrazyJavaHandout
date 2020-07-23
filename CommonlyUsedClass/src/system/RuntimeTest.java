package system;

import java.util.concurrent.CompletableFuture;

/**
 * @author Nina
 * DateTime 2020/7/22 21:00
 * Description runtime
 */
public class RuntimeTest {
    public static void main(String[] args) throws Exception {
        //获取Java程序关联的运行时对象
        Runtime runtime = Runtime.getRuntime();
        System.out.println("处理器数量" + runtime.availableProcessors());
        System.out.println("空闲内存数" + runtime.freeMemory() + "Bytes");
        System.out.println("总内存数" + runtime.totalMemory() + "Bytes");
        System.out.println("最大可用内存数" + runtime.maxMemory() + "Bytes");
        //运行记事本,成为一个进程
        Process process = runtime.exec("C:\\Program Files (x86)\\Notepad++\\notepad++.exe");
        ProcessHandle processHandle = process.toHandle();
        System.out.println("进程是否运行" + processHandle.isAlive());
        System.out.println("进程ID" + processHandle.pid());
        System.out.println("父进程" + processHandle.parent());
        //获取ProcessHandle.Info信息
        ProcessHandle.Info info = processHandle.info();
        //通过ProcessHandle.Info获取进程相关信息
        System.out.println("进程命令" + info.command());
        System.out.println("进程参数" + info.arguments());
        Thread.sleep(500);
        System.out.println("进程启动时间" + info.startInstant());
        System.out.println("进程累计运行时间" + info.totalCpuDuration());
        //通过CompleteFuture在进程结束时运行某个任务
        CompletableFuture<ProcessHandle> completableFuture = processHandle.onExit();
        completableFuture.thenRunAsync(() -> System.out.println("程序退出"));
        //以上Lambda表达式等同于下面的代码
        /*completableFuture.thenRunAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("程序退出");
            }
        });*/
        Thread.sleep(5000);
    }
}
