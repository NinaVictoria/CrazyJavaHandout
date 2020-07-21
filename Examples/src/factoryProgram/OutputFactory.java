package factoryProgram;

/**
 * @author Nina
 * DateTime 2020/7/21 20:05
 * Description 所有Output对象的逻辑集中在OutputFactory工厂类中夫案例
 */
public class OutputFactory {
    public Output getOutput() {
        return new Printer();
    }

    public Output getBetterOutput() {
        return new BetterPrinter();
    }

    public static void main(String[] args) {
        OutputFactory of = new OutputFactory();
        Computer c = new Computer(of.getOutput());
        c.keyIn("简单工厂模式");
        c.keyIn("疯狂Java讲义");
        c.print();

        c = new Computer(of.getBetterOutput());
        c.keyIn("现在用的是better printer");
        c.keyIn("------");
        c.print();
    }
}
