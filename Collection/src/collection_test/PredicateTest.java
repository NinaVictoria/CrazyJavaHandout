package collection_test;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * @author Nina
 * DateTime 2020/7/26 23:23
 * Description
 */
public class PredicateTest {
    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("Java");
        books.add("C++");
        books.add("C#");
        //统计书名包含C的图书数量
        System.out.println(calAll(books, ele -> ((String) ele).contains("C")));
    }

    public static int calAll(Collection books, Predicate p) {
        int total = 0;
        for (Object obj : books) {
            if (p.test(obj)) {
                total++;
            }
        }
        return total;
    }
}
