package HideTest;

/**
 * @author Nina
 * DateTime 2020/7/20 15:14
 * Description 隐藏父类的实例变量
 */
public class HideTest {
    public static void main(String[] args) {
        Derived d = new Derived();
        //System.out.println(d.tag);
        //不可访问，d的tag为私有
        if (d instanceof Parent)
            System.out.println(((Parent) d).tag);
        //上转型为Parent后，输出为Parent
    }
}

class Parent {
    public String tag = "Parent";
}

class Derived extends Parent {
    //私有的tag实例变量，隐藏了父类的tag实例变量
    private String tag = "Derived";
}
