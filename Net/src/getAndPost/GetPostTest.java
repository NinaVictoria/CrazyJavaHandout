package getAndPost;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author Nina
 * DateTime 2020/8/9 22:47
 * Description
 */
public class GetPostTest {

    /**
     * description: 向指定的URL发送GET方式的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，满足name1=value1&name2=value2的格式
     * @return URL 代表远程资源的响应
     */
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realURL = new URL(urlName);
            //打开URL之间的连接
            URLConnection conn = realURL.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //建立实际的连接
            conn.connect();
            //获取所有的响应字段头
            Map<String, List<String>> map = conn.getHeaderFields();
            //遍历所有的响应字段头
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            try (
                    //定义BufferedReader输入流来读取URL响应
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))
            ) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * description: 向指定的URL发送POST方式的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，满足name1=value1&name2=value2的格式
     * @return URL代表远程资源的响应
     */
    public static String sendPost(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realURL = new URL(urlName);
            //打开URL之间的连接
            URLConnection conn = realURL.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //发送POST请求需要设置如下2行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            try (
                    //获取URLConnection对象对应的输出流
                    PrintWriter out = new PrintWriter(conn.getOutputStream())
            ) {
                //发送请求参数
                out.print(param);
                //flush缓冲流
                out.flush();
            }
            try (
                    //定义BufferedReader输入流来读取URL响应
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))
            ) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //测试用主方法
    public static void main(String[] args) {
        //发送GET请求
        String s=GetPostTest.sendGet("http://www.baidu.com",null);
        System.out.println(s);
        //发送POST请求
        String s1=GetPostTest.sendPost("http://www.baidu.com",null);
        System.out.println(s1);
    }
}