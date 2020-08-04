import java.util.ArrayList;
import java.util.List;

/**
 * @author Nina
 * DateTime 2020/8/4 9:47
 * Description 5个基本注解
 * @Override
 * @Deprecated
 * @SuppressWarnings
 * @SafeVarargs
 * @FunctionalInterface
 */
public class BasicAnnotationTest {
    /* @Override注解
     * 指定方法为重写父类的方法
     * 帮助调试
     */
    @Override
    public String toString() {
        return super.toString();
    }

    //关闭程序元素以及子元素中的编译器警告
    @SuppressWarnings(value = "unchecked")

    public static void main(String[] args) {
        new Apple().info();
        //没有使用泛型
        List myList = new ArrayList<Integer>();
        myList.add(20);
        //引起“未经检查的转换”警告，编译运行正常
        List<String> ls = myList;
        //访问元素时，即发生运行时异常
        //将不带泛型的对象赋给带泛型的变量，往往发生堆污染
        System.out.println(ls.get(0));
        //使用@SafeVarargs可以影藏堆污染警告
    }
}

class Apple {
    //定义info方法已过时
    //since属性指定哪个版本开始，forRemoval指定该API将来会被删除
    @Deprecated(since = "9", forRemoval = true)
    public void info() {
        System.out.println("Apple的info()方法");
    }
}