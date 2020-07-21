package commandPattern;

/**
 * @author Nina
 * DateTime 2020/7/21 20:35
 * Description 实现Command接口,内部行为为求和
 */
public class AddCommand implements Command {
    @Override
    public void process(int[] target) {
        int sum = 0;
        for (int tmp : target) {
            sum += tmp;
        }
        System.out.println("数组元素的和为：" + sum);
    }

}
