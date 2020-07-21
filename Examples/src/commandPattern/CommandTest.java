package commandPattern;

/**
 * @author Nina
 * DateTime 2020/7/21 20:31
 * Description 把”行为“作为参数传如方法内，实际执行时依据不同的方法得到不同的结果
 * 实现process()方法和”处理行为“的分离
 */
public class CommandTest {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] target = {5, 3, -5, 4, 9};
        //第一次处理数组，具体行为取决于PrintCommand
        pa.process(target, new PrintCommand());
        System.out.println("------------");
        //第二次处理数组，具体行为取决与AddCommand
        pa.process(target, new AddCommand());
    }
}
