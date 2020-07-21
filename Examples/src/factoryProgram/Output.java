package factoryProgram;

public interface Output {
    int MAX_CACHE_LINE = 50;//成员变量只能是常量

    public abstract void out();//接口内的普通方法只能是公共的抽象方法

    public abstract void getData(String msg);

    //接口内定义的默认方法，需要用default修饰
    default void print(String... msgs) {
        for (String msg : msgs) {
            System.out.println(msg);
        }
    }


    default void test() {
        System.out.println("默认的test()方法");
    }

    //接口内的类方法，需要用static修饰
    static String staticTest() {
        return "接口里的类方法";
    }

    //私有方法
    private void foo() {
        System.out.println("foo()私有方法");
    }

    //私有静态方法
    private static void bar() {
        System.out.println("bar()私有静态方法");
    }
}
