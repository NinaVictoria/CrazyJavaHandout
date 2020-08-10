import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Nina
 * DateTime 2020/8/10 11:06
 * Description 使用反射生成对象
 */
public class ObjectPoolFactory {
    //对象池，key为对象名，value为实际对象
    private Map<String, Object> objectPool = new HashMap<>();

    /**
     * description: 定义一个创建对象的方法，传入字符串类名，根据类名生成对象
     *
     * @param clazzName 传入的字符串类名
     * @return 返回生成的对象
     */
    private Object createObject(String clazzName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //根据字符串获取Class对象
        Class<?> clazz = Class.forName(clazzName);
        //使用clazz对应类的默认构造器创建实例
        return clazz.getConstructor().newInstance();
    }

    /**
     * description: 根据指定的文件内容创建对象，并添加到对象池objectPool
     *
     * @param fileName 指定文件名
     * @return void
     */
    public void initPool(String fileName) {

        try (
                FileInputStream fis = new FileInputStream(fileName)
        ) {
            Properties properties = new Properties();
            properties.load(fis);
            for (String name : properties.stringPropertyNames()) {
                //每取出一对key-value，就创建一个对象
                //调用createObject方法，并将对象添加到对象池
                objectPool.put(name, createObject(properties.getProperty(name)));
            }
        } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * description: 从objectPool中取出指定的对象
     *
     * @param name 对象的name
     * @return 对象池中名字为name的对象
     */
    public Object getObject(String name) {
        return objectPool.get(name);
    }

    public static void main(String[] args) {
        ObjectPoolFactory pf = new ObjectPoolFactory();
        pf.initPool(".\\src\\obj.txt");
        System.out.println(pf.getObject("string1"));
        System.out.println(pf.getObject("a"));
    }

}
