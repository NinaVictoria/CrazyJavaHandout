package iostream;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * @author Nina
 * DateTime 2020/8/7 15:50
 * Description class:RandomAccessFile
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try (
                RandomAccessFile raf = new RandomAccessFile(".\\src\\iostream\\RandomAccessFileTest.java", "r")
                /** mode
                 * "r" 只读
                 * "rw" 读写,如果文件不存在，则尝试创建该文件
                 * "rws" 额外要求对文件内容或元数据的每个更新都同步写入到底层存储设备
                 * "rwd" 额外要求对文件内容的每个更新都同步写入到底层存储设备
                 */
        ) {
            System.out.println("文件指针的初始位置:" + raf.getFilePointer());
            raf.seek(300);
            byte[] bbuf = new byte[512];
            int hasRead = 0;
            while ((hasRead = raf.read(bbuf)) > 0) {
                System.out.println(new String(bbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
