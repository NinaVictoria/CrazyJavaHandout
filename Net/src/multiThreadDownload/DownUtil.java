package multiThreadDownload;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Nina
 * DateTime 2020/8/9 16:36
 * Description 多线程下载工具类
 */
public class DownUtil {
    //下载资源的路径
    private String path;
    //指定下载文件的保存位置
    private String targetFile;
    //定义下载的线程数
    private int threadNum;
    //定义下载的线程对象
    private DownThread[] threads;
    //定义下载的文件总大小
    private int fileSize;

    public DownUtil(String path, String targetFile, int threadNum) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        threads = new DownThread[threadNum];
    }

    public void download() throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, " +
                "application/x-shockwave-flash, application/xaml+xml, " +
                "application/vnd.ms-xpsdocument, application/x-ms-xbap, " +
                "application/x-ms-application, application/vnd.ms-excel, " +
                "application/vnd.ms-powerpoint, application/vnd.ms-word, */*");
        conn.setRequestProperty("AcceptLanguage", "zh-CN");
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");
        //得到文件大小
        fileSize = conn.getContentLength();
        System.out.println("文件大小:" + fileSize);
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        //设置本地文件大小
        file.setLength(fileSize);
        file.close();
        for (int i = 0; i < threadNum; i++) {
            //计算每个线程下载的开始位置
            int startPos = i * currentPartSize;
            //每个线程使用一个RandomAccessFile进行下载
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
            //定位该线程的下载位置
            currentPart.seek(startPos);
            threads[i] = new DownThread(startPos, currentPartSize, currentPart);
            //启动下载线程
            threads[i].start();
        }
    }

    //获取下载完成的百分比
    public double getCompleteRate() {
        //统计多个线程已经下载的总大小
        int sumSize = 0;
        for (int i = 0; i < threadNum; i++) {
            sumSize += threads[i].length;
        }
        return sumSize * 1.0 / fileSize;
    }

    public class DownThread extends Thread {
        //当前线程的下载位置
        private int startPos;
        //当前线程负责下载的文件大小
        private int currentPartSize;
        //当前线程需要下载的文件块
        private RandomAccessFile currentPart;
        //定义已下载的字节数
        private int length;

        public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.currentPart = currentPart;
            this.currentPartSize = currentPartSize;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, " +
                        "application/x-shockwave-flash, application/xaml+xml, " +
                        "application/vnd.ms-xpsdocument, application/x-ms-xbap, " +
                        "application/x-ms-application, application/vnd.ms-excel, " +
                        "application/vnd.ms-powerpoint, application/vnd.ms-word, */*");
                conn.setRequestProperty("AcceptLanguage", "zh-CN");
                conn.setRequestProperty("Charset", "UTF-8");
                InputStream inputStream = conn.getInputStream();
                //跳过startPos字节,只下载自己的部分
                inputStream.skip(this.startPos);
                byte[] buffer = new byte[1024];
                int hasRead = 0;
                //读取网络数据，写入本地文件
                while (length < currentPartSize && (hasRead = inputStream.read(buffer)) != -1) {
                    currentPart.write(buffer, 0, hasRead);
                    //累计该线程下载的总大小
                    length += hasRead;
                }
                currentPart.close();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
