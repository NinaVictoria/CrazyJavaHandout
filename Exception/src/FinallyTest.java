import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Nina
 * DateTime 2020/8/1 15:50
 * Description finally
 */
public class FinallyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return; //return方法强制返回之前会执行finally块中的代码
            //如果使用了exit方法退出虚拟机，则不会执行finally块
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("回收资源");
        }
    }
}
