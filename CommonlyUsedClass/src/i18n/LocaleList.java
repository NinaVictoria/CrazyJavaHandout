package i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Nina
 * DateTime 2020/7/26 16:32
 * Description i18n test
 */
public class LocaleList {
    public static void main(String[] args) {
        //返回Java所支持的全部国家和语言的数组
        Locale[] locales = Locale.getAvailableLocales();
        //遍历数组的每个元素，一次获取支持的国家和语言
        for (int i = 0; i < locales.length; i++) {
            System.out.println(locales[i].getDisplayCountry() + "=" + locales[i].getCountry() + " " + locales[i].getDisplayLanguage() + "=" + locales[i].getLanguage());
        }

        //获得系统默认的国家/语言环境
        Locale myLocale=Locale.getDefault(Locale.Category.FORMAT);
        //根据指定的国家/语言环境加载资源文件
        ResourceBundle bundle=ResourceBundle.getBundle("i18n\\mess",myLocale);
        System.out.println(bundle.getString("hello"));

        //使用MessageFormat处理包含占位符的字符串
        String msg=bundle.getString("msg");
        System.out.println(MessageFormat.format(msg,"Nina",new Date()));
    }
}
