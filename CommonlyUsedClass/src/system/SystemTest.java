package system;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author Nina
 * DateTime 2020/7/22 20:47
 * Description System class
 */
public class SystemTest {
    public static void main(String[] args) throws Exception {
        Map<String, String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name + " --> " + env.get(name));
        }
        System.out.println(System.getenv("JAVA_HOME"));
        Properties properties = System.getProperties();
        properties.store(new FileOutputStream("props.txt"), "System Properties");
        System.out.println(System.getProperty("os.name"));
        //当前时间与UTC 1970-1-1 0:0:0的时间差，单位为毫秒
        System.out.println(System.currentTimeMillis());
        //当前时间与UTC 1970-1-1 0:0:0的时间差，单位为纳秒
        System.out.println(System.nanoTime());
        //根据地址计算得到的hashCode值，唯一标识该对象。若相等，则一定是同一个对象
        System.out.println(System.identityHashCode(env));
    }
}
