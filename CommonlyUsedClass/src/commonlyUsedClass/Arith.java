package commonlyUsedClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Nina
 * DateTime 2020/7/23 16:37
 * Description A tool class, supports precise mathematical operations
 */
public class Arith {
    //默认的除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    //构造器私有
    private Arith() {
    }

    //提供精确的加法运算
    public static double add(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    //提供精确的减法运算
    public static double subtract(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    //提供精确的乘法运算
    public static double multi(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }

    //提供相对精确的除法运算
    //当发生除不尽的情况时，精确到小数点后10位
    public static double divide(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, DEF_DIV_SCALE, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        double d1 = 123.3, d2 = 100;
        System.out.println(d1 / d2);
        System.out.println(Arith.divide(d1, d2));
    }
}
