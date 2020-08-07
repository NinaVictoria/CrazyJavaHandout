package serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Nina
 * DateTime 2020/8/7 16:01
 * Description
 */
public class WriteObject {
    public static void main(String[] args) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".\\src\\serializable\\object.txt"))
        ) {
            Person person = new Person("孙悟空", 500);
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
