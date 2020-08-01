package definition;


import java.util.Set;

/**
 * @author Nina
 * DateTime 2020/8/1 10:32
 * Description 定义泛型
 */
public class GenericTest<T> {
    public static void main(String[] args) {
        GenericTest<String> a1 = new GenericTest<>();
    }

    public void test(List<?> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }
}

interface List<E> {
    void add(E x);

    int size();

    Iterator<E> iterator();

    E get(int i);
}

interface Iterator<E> {
    E next();

    boolean hasNext();
}

interface Map<K, V> {
    Set<K> keySet();

    V put(K key, V value);
}