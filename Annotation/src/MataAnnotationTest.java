import java.lang.annotation.*;

/**
 * @author Nina
 * DateTime 2020/8/4 10:11
 * Description MataAnnotation
 */

//使用Inherited修饰的注解将具有继承性
//其子类将自动被该注解修饰
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Inheritable {
}

@Inheritable
class Base {
}


public class MataAnnotationTest extends Base {
    public static void main(String[] args) {
        System.out.println(MataAnnotationTest.class.isAnnotationPresent(Inheritable.class));
    }
}

//以下注解指定@ActionListenerFor注解只能修饰构造器
@Target(ElementType.CONSTRUCTOR)
@interface ActionListenerFor {
}




