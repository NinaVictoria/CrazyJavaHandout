/**
 * @author Nina
 * DateTime: 2020/7/8 17:28
 * Description: Learn to use Javadoc
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("1+2="+add(1,2));
    }


    protected static int add(int a, int b){
        /**
         * description: add two int numbers.
         *
         * @param a a add member
         * @param b another add member
         * @return int return the sum
         */
        return a+b;
    }

}
