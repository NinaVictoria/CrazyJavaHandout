package PrimitiveAndString;

/**
 * @author Nina
 * DateTime 2020/7/9 16:46
 * Description 希望将基本数据类型的值转换为相对应的字符串时，可以和一个空字符串（""）连接
 */
public class PrimitiveAndString {
    public static void main(String[] args) {
        System.out.println(3 + 4 + "Hello!");   //先计算3+4，得到7，7加上一个字符串，+当成字符串连接，所以输出为7Hello！
        System.out.println("Hello!" + 3 + 4);   //同理，2个+都是字符串连接，所以输出为Hello!34
        System.out.println(true + "");
        System.out.println("Hello" + 'a' + 7);      //字符串连接，输出Helloa7
        System.out.println('a' + 7 + "Hello");      //'a'自动提升为int类型，值为97，所以输出104Hello


        System.out.println("5/0.0=" + 5 / 0.0); //正无穷Infinity
        System.out.println("-5/0.0=" + -5 / 0.0);   //负无穷-Infinity
        System.out.println("-5%0.0=" + -5 % 0.0);   //非数NaN

        /**
         * 自动类型转换
         * 左边可以自动转换为右边的类型
         * char->int
         * byte->short->int->long->float->double
         */
    }
}