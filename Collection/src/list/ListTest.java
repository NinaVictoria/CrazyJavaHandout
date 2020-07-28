package list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Nina
 * DateTime 2020/7/28 14:55
 * Description List
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Python");
        books.add("C");
        books.add("C++");
        System.out.println(books);
        books.sort(Comparator.comparingInt(String::length));
        System.out.println(books);
        books.replaceAll(ele -> String.valueOf(ele.length()));
        System.out.println(books);
        ListIterator listIterator = books.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        System.out.println("======反向迭代======");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

    }
}
