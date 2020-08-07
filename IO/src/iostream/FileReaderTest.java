package iostream;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nina
 * DateTime 2020/8/7 14:45
 * Description FileReader
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        try (
                //创建字符输入流
                FileReader fileReader = new FileReader(".\\src\\iostream\\FileReaderTest.java")
        ) {
            char[] cbuf = new char[32];
            int hasRead = 0;
            while ((hasRead = fileReader.read(cbuf)) > 0) {
                System.out.print(new String(cbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
