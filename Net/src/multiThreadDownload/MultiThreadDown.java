package multiThreadDownload;

/**
 * @author Nina
 * DateTime 2020/8/9 17:09
 * Description test DownUtil
 */
public class MultiThreadDown {
    public static void main(String[] args) throws Exception {
        //初始化DownUtil对象
        //final DownUtil downUtil = new DownUtil("http://www,crazyit.org/attachements/month_1403/1403202355ff6cc9a4fbf6f14a.png", ".\\src\\multiThreadDownload\\ios.png", 4);
        final DownUtil downUtil = new DownUtil("https://modpack-1257209710.cos.ap-guangzhou.myqcloud.com/Age%20of%20Engineering-1.1.2-windows.zip", ".\\src\\multiThreadDownload\\test.zip", 4);
        //开始下载
        downUtil.download();
        new Thread(() -> {
            while (downUtil.getCompleteRate() < 1) {
                //每隔0.05秒查询一次任务的进度
                //GUI中根据该进度绘制进度条
                System.out.println("已完成:" + downUtil.getCompleteRate());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
