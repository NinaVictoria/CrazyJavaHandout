package commandPattern;

/**
 * @author Nina
 * DateTime 2020/7/21 21:16
 * Description Lambda表达式
 */
public class CommandTest2 {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] array = {5, 3, -5, 4, 9};
        pa.process(array, (int[] target) -> {
            for (int tmp : target) {
                System.out.println("迭代输出的数组元素：" + tmp);
            }
        });

        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        };
        r.run();

        Add add = (int a, int b) -> a + b;  //Lanbda表达式的结果被当成对象处理，相当于实现了对应函数式接口的对象，可以赋值给该接口声明的引用变量
        //函数式接口：只含有一个抽象方法的接口
        System.out.println(add.add(5, 10));
    }
}

@FunctionalInterface    //没有作用，但是编译器会严格检查该接口是否为函数式接口，即只含有一个抽象方法
interface Add {
    int add(int a, int b);
}
