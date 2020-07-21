package commandPattern;

/**
 * @author Nina
 * DateTime 2020/7/21 20:34
 * Description 实现Command接口,内部行为为迭代输出
 */
public class PrintCommand implements Command {
    @Override
    public void process(int[] target) {
        for(int tmp:target){
            System.out.println("迭代输出的数组元素："+tmp);
        }
    }
}
