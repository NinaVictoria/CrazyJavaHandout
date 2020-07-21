package singleton;

/**
 * @author Nina
 * DateTime 2020/7/21 15:47
 * Description singleton
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("s1==s2?  " + (s1 == s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

class Singleton {
    private static Singleton instance;  //缓存

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}