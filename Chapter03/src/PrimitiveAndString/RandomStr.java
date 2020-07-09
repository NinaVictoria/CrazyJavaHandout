package PrimitiveAndString;

/**
 * @author Nina
 * DateTime 2020/7/9 16:52
 * Description generate a random String
 */
public class RandomStr {
    public static void main(String[] args) {
        String result = "";
        for (int i = 0; i < 10; i++) {
            //生成随机字母的int值
            int intVal = (int) (Math.random() * 26 + 97);
            result = result + (char) intVal;
        }
        System.out.println(result);
    }
}
