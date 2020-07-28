package set;

import java.util.TreeSet;

/**
 * @author Nina
 * DateTime 2020/7/28 14:14
 * Description TreeSet
 * 如果将一个对象添加到TreeSet，则必须实现Comparable接口
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(-2);
        numbers.add(10);
        numbers.add(-9);
        System.out.println(numbers);

        //自然排序
        TreeSet<Z> zs = new TreeSet<>();
        zs.add(new Z(10));
        zs.add(new Z(20));
        zs.add(new Z(15));
        zs.add(new Z(35));
        System.out.println(zs);
        System.out.println(zs.first());

        //定制排序,通过Comparator接口
        TreeSet<Z> zs1 = new TreeSet<>((o1, o2) -> Integer.compare(o2.age, o1.age));
        zs1.add(new Z(10));
        zs1.add(new Z(20));
        zs1.add(new Z(15));
        zs1.add(new Z(35));
        System.out.println(zs1);

    }
}

class Z implements Comparable {
    int age;

    Z(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == Z.class) {
            Z z = (Z) obj;
            return z.age == this.age;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        Z z = (Z) o;
        return Integer.compare(age, z.age);
    }

    @Override
    public String toString() {
        return "z.age = " + age;
    }
}