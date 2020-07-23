package commonlyUsedClass;

/**
 * @author Nina
 * DateTime 2020/7/23 16:18
 * Description class:StringBuilder
 *             StringBuilder的字符串是可变的，不会在操作过程中产生大量临时变量
 *             StringBuffer是线程安全的，StringBuilder不是，但其性能更高
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("java");
        System.out.println(stringBuilder);
        stringBuilder.insert(0,"Hello ");
        System.out.println(stringBuilder);
        stringBuilder.replace(5,6,",");
        System.out.println(stringBuilder);
        stringBuilder.delete(5,6);
        System.out.println(stringBuilder);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder.capacity());
        stringBuilder.setLength(5);
        System.out.println(stringBuilder);
    }
}
