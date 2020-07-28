import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Nina
 * DateTime 2020/7/28 15:22
 * Description
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(".\\src\\a.ini"));
        System.out.println(properties);
        properties.store(new FileOutputStream(".\\src\\c.xml"), "comment line");
    }
}
