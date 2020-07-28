package set;

import java.util.EnumSet;

/**
 * @author Nina
 * DateTime 2020/7/28 14:42
 * Description EnumSet
 */
enum Season{
    SPRING,SUMMER,FALL,WINTER
}

public class EnumSetTest {
    public static void main(String[] args) {
        EnumSet<Season> enumSet=EnumSet.allOf(Season.class);
        System.out.println(enumSet);
        EnumSet<Season> enumSet1=EnumSet.noneOf(Season.class);
        System.out.println(enumSet1);
        enumSet1.add(Season.FALL);
        enumSet1.add(Season.WINTER);
        System.out.println(enumSet1);
    }
}
