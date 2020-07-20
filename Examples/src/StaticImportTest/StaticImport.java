package StaticImportTest;

import static java.lang.System.*;
import static java.lang.Math.*;

/**
 * @author Nina
 * DateTime 2020/7/20 10:40
 * Description 使用import static语句导入静态成员变量，简化程序
 */
public class StaticImport {
    public static void main(String[] args) {
        out.println(PI);
        out.println(sqrt(256));
    }
}
