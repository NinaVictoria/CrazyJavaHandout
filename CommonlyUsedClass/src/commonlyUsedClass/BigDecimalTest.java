package commonlyUsedClass;

import java.math.BigDecimal;

/**
 * @author Nina
 * DateTime 2020/7/23 16:30
 * Description BigDecimal
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal_1 = new BigDecimal("0.170063");
        //推荐使用String作为参数，不推荐下面的写法，可能会导致精度丢失
        //bigDecimal=new BigDecimal(0.1);
        //如果一定要使用Double类型作为参数，推荐
        //bigDecimal=BigDecimal.valueOf(0.1);
        BigDecimal bigDecimal_2=BigDecimal.valueOf(0.00034);
        System.out.println(bigDecimal_1.add(bigDecimal_2));
    }
}
