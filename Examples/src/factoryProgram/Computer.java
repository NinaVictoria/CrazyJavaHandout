package factoryProgram;

/**
 * @author Nina
 * DateTime 2020/7/21 19:53
 * Description 面向接口编程，让Computer类组合一个Output接口类型的对象
 */
public class Computer {
    private Output out;

    public Computer(Output out) {
        this.out = out;
    }

    //模拟获取字符串输入
    public void keyIn(String msg) {
        out.getData(msg);
    }

    //模拟打印的方法
    public void print() {
        out.out();
    }
}
