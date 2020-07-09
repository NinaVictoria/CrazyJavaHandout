package PrimitiveAndString;

/**
 * @author Nina
 * DateTime 2020/7/9 17:02
 * Description
 */
public class AutoPromote {
    public static void main(String[] args) {
        short sVal = 10;
        //short sResult=sVal+2;     Error, sVal+2 return a int value.
        sVal += 2;              //+=和+的底层实现机制不同，不会出错
        int sResult = sVal + 2;
        System.out.println(sResult);
    }
}
