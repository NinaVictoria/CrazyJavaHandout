package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nina
 * DateTime 2020/7/26 16:01
 * Description regular expression
 */
public class RegexTest {
    public static void main(String[] args) {
        //正则表达式的使用方法
        //将一个字符串编译成Pattern对象
        Pattern pattern = Pattern.compile("a*b");
        //使用Pattern对象创建Matcher对象
        Matcher m = pattern.matcher("aaaaaaaaaaaab");
        System.out.println(m.matches());

        //抓取电话号码
        String str = "联系我，电话13800001234" + "交朋友+15866669999";
        pattern = Pattern.compile("((13\\d)|(15\\d))\\d{8}");
        m = pattern.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }

        //确定子串在目标字符串上的位置
        String regStr="Java is very easy!";
        System.out.println("目标字符串是："+regStr);
        m=Pattern.compile("\\w+").matcher(regStr);
        while (m.find()){
            System.out.println(m.group()+"起始位置"+m.start()+",结束位置"+m.end());
        }
    }
}
