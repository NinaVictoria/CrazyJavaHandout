package enumtest;

/**
 * @author Nina
 * DateTime 2020/7/22 11:03
 * Description enum
 */
public class EnumTest {
    public void judge(SeasonEnum s) {
        switch (s) {
            case SPRING:
                System.out.println("春暖花开");
                break;
            case SUMMER:
                System.out.println("夏日炎炎");
                break;
            case FALL:
                System.out.println("秋高气爽");
                break;
            case WINTER:
                System.out.println("冬日雪飘");
                break;
        }
    }

    public static void main(String[] args) {
        //SeasonEnum.values()方法返回该枚举类型的所有实例
        for (SeasonEnum s : SeasonEnum.values()) {
            System.out.println(s);
        }
        //通过EnumClass.variable访问枚举实例
        new EnumTest().judge(SeasonEnum.SUMMER);
    }
}
