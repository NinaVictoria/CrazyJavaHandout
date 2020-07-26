package collection_test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * @author Nina
 * DateTime 2020/7/26 23:03
 * Description 遍历集合
 */
public class LambdaTest {
    public static void main(String[] args) {
        //使用Lambda表达式遍历集合
        Collection books = new HashSet();
        books.add("Java");
        books.add("C++");
        books.add("C#");
        //调用forEach()方法遍历集合
        books.forEach(o -> System.out.println("迭代集合元素：" + o));

        //使用Java8增强的Iterator遍历集合元素
        Iterator iterator = books.iterator();
        while (iterator.hasNext()) {
            String book = (String) iterator.next();
            System.out.println(book);
            if (book.equals("C#"))
                iterator.remove();
        }

        //使用Lambda表达式遍历Iterator
        iterator = books.iterator();
        iterator.forEachRemaining((obj) -> System.out.println("迭代集合元素:" + obj));
        //使用Iterator迭代过程中，不可修改集合元素
        System.out.println(books);

        //使用Java8新增的Predicate操作集合
        books.add("Python");
        books.add("Android");
        //使用Lambda表达式过滤集合
        //批量删除长度小于等于3的元素
        books.removeIf(ele -> ((String) ele).length() <= 3);
        System.out.println(books);

        //使用Java8新增的Stream操作集合
        IntStream is = IntStream.builder().add(20).add(14).add(56).build();
        //下面的代码是末端方法，只能执行一次
        //末端方法，对流的最终操作
        //中间方法，返回的仍然是一个流
//        System.out.println("is所有元素的最大值:" + is.max().getAsInt());
//        System.out.println("is所有元素的和:" + is.sum());
        System.out.println("is所有元素的平方是否都大于20:" + is.allMatch(ele -> ele * ele > 20));
        System.out.println(books);
        //统计书名包含"C"子串的图书数量
        System.out.println(books.stream().filter(ele -> ((String) ele).contains("C")).count());
        //先调用Collection对象的stream()方法将集合转化为Stream
        //再调用Stream的mapToInt()方法获取原有的Stream对应的IntStream
        //调用forEach()方法遍历IntStream中的每个元素
        books.stream().mapToInt(ele -> ((String) ele).length()).forEach(System.out::println);
    }
}
