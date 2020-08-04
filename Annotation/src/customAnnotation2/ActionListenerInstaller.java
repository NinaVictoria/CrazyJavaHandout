package customAnnotation2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * @author Nina
 * DateTime 2020/8/4 11:16
 * Description
 */
public class ActionListenerInstaller {
    //处理注解的方法
    public static void processAnnotation(Object obj) {
        try {
            //获取obj对象的类
            Class c1 = obj.getClass();
            //获取指定obj对象的所有成员变量，并遍历
            for (Field f : c1.getDeclaredFields()) {
                //将该成员变量设置为自由访问
                f.setAccessible(true);
                //获取成员变量上的ActionListenerFor注解
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                //获取成员变量f的值
                Object fObj = f.get(obj);
                //如果f时AbstractButton的实例，并且a不为null
                if (a != null && fObj != null && fObj instanceof AbstractButton) {
                    //获取a注解里的listener元数据
                    Class<? extends ActionListener> listenerClazz = a.listener();
                    //使用反射来创建Listener类的对象
                    ActionListener a1 = listenerClazz.newInstance();
                    AbstractButton ab = (AbstractButton) fObj;
                    //为ab按钮添加监听器事件
                    ab.addActionListener(a1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
