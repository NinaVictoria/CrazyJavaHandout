package customAnnotation;

import java.lang.reflect.Method;

/**
 * @author Nina
 * DateTime 2020/8/4 10:37
 * Description 注解处理工具，分析目标类，如果目标使用了注解，则通过反射来运行测试方法
 */
public class ProcessorTest {
    public static void process(String clazz) throws ClassNotFoundException {
        int passed = 0;
        int failed = 0;
        //遍历clazz对应类中的所有方法
        for (Method m : Class.forName(clazz).getMethods()) {
            //如果使用了Testable注解
            if (m.isAnnotationPresent(Testable.class)) {
                try {
                    //调用m方法
                    m.invoke(null);
                    passed++;
                } catch (Exception e) {
                    System.out.println("方法" + m + "运行失败,异常:" + e.getCause());
                    failed++;
                }
            }
        }
        System.out.println("共运行了" + (passed + failed) + "个方法，其中失败了" + failed + "个，成功了" + passed + "个");
    }
}
