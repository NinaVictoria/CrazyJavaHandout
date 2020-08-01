import java.io.*;

/**
 * @author Nina
 * DateTime 2020/8/1 16:01
 * Description 自动关闭资源的try语句
 */
public class AutoCloseTest {
    public static void main(String[] args) throws IOException {
        try (
                //Java 7
                //声明初始化可关闭的资源，try语句会自动关闭
                BufferedReader br = new BufferedReader(new FileReader(".\\src\\AutoCloseTest.java"));
                PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))
        ) {
            System.out.println(br.readLine());
            ps.println("aaaaaaaaaaaaaaaaaa");
        }

        //Java9 增强的try语句
        final BufferedReader br1 = new BufferedReader(new FileReader(".\\src\\AutoCloseTest.java"));
        final PrintStream ps1 = new PrintStream(new FileOutputStream("b.txt"));
        try (br1; ps1) {
            System.out.println(br1.readLine());
            ps1.println("aaaaaaaaaaaaaaaaaa");
        }
    }
}
