package customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Testable {
    //以方法的形式来定义成员变量的方法和名字
    //使用时，使用@customAnnotation.Testable(name="xxx",age=6)
    //含有默认值时，可以不指定变量值
    String name() default "nina";

    int age() default 20;
}
