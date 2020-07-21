package commandPattern;


/**
 * @author Nina
 * DateTime 2020/7/21 20:29
 * Description 需要处理数组的数组类
 */
public class ProcessArray {
    public void process(int[] target, Command cmd) {
        cmd.process(target);
    }
}
