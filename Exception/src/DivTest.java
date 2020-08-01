import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author Nina
 * DateTime 2020/8/1 15:26
 * Description Exception Test
 */
public class DivTest {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a / b;
            System.out.println(c);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("数组越界");
        } catch (NumberFormatException e) {
            System.out.println("数字格式异常");
        } catch (ArithmeticException e) {
            System.out.println("算术异常");
        } catch (Exception e) {
            System.out.println("未知异常");
            //常用异常方法
            e.getMessage(); //返回该异常得详细描述字符串
            e.printStackTrace();    //输出到控制台
            e.printStackTrace(new PrintStream("a.txt"));    //输出到指定输出流
            e.getStackTrace();  //返回该异常得跟踪栈信息
        }
    }
}
