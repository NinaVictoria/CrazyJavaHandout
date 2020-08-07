package file;

import java.io.File;
import java.io.IOException;

/**
 * @author Nina
 * DateTime 2020/8/7 13:41
 * Description Class File and FileFilter
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //以当前路径创建一个File对象
        File file = new File(".");
        System.out.println(file.getName());
        //输出父路径
        System.out.println(file.getParent());
        //获取绝对路径
        System.out.println(file.getAbsoluteFile());
        //获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        //在当前路径创建一个临时文件
        File tmpFile = File.createTempFile("aaa", ".txt", file);
        //指定当JVM退出时删除该文件
        tmpFile.deleteOnExit();
        //以系统当前时间作为新文件名来创建文件
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println(newFile.exists());
        newFile.createNewFile();
        System.out.println(newFile.exists());
        System.out.println(newFile.mkdir());
        //使用List()方法列出当前路径下的所有文件和路径
        String[] fileList = file.list();
        System.out.println("=====当前路径下所有文件和路径如下=====");
        for (String filename : fileList) {
            System.out.println(filename);
        }

        File[] roots = File.listRoots();
        System.out.println("=====系统所有根路径如下=====");
        for (File root : roots) {
            System.out.println(root);
        }

        //FileFilter
        String[] nameList = file.list(((dir, name) -> name.endsWith(".java") || new File(name).isDirectory()));
        for (String name : nameList) {
            System.out.println(name);
        }
    }
}
