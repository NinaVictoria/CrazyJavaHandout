package autoBoxingUnboxing;

/**
 * @author Nina
 * DateTime 2020/7/21 15:00
 * Description 自动装箱和拆箱
 * 字符串类型和基本类型之间的转换
 */
public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        Integer integer = 5;
        Object boolObj = true;
        int i = integer;
        if (boolObj instanceof Boolean) {
            boolean b = (Boolean) boolObj;
            System.out.println(b);
        }

        String intStr = "1234";
        int int1 = Integer.parseInt(intStr);
        int int2 = Integer.valueOf(intStr);
        System.out.println(int1 + " " + int2);

        String floatStr = "3.14";
        float float1 = Float.parseFloat(floatStr);
        float float2 = Float.valueOf(floatStr);
        System.out.println(float1 + " " + float2);

        String ftStr = String.valueOf(3.456f);
        System.out.println(ftStr);

        String boolStr = String.valueOf(false);
        System.out.println(boolStr.toUpperCase());
    }
}
