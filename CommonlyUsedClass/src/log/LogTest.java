package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nina
 * DateTime 2020/7/26 17:11
 * Description log API in Java 9
 */
public class LogTest {
    public static void main(String[] args) throws IOException {
        //获取System.Logger对象
        System.Logger logger=System.getLogger("fkjava");
        //设置系统日志级别
        Logger.getLogger("fkjava").setLevel(Level.FINE);
        //使用a.xml保存日志记录
        Logger.getLogger("fkjava").addHandler(new FileHandler("a.xml"));
        logger.log(System.Logger.Level.DEBUG,"Debug信息");
        logger.log(System.Logger.Level.INFO,"info信息");
        logger.log(System.Logger.Level.ERROR,"Error信息");
    }
}
