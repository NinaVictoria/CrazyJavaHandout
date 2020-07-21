package commandPattern;

public interface Command {
    //定义的process方法用于封装“处理行为”
    void process(int[] target);
}
