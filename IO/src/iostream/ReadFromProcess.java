package iostream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Nina
 * DateTime 2020/8/7 15:39
 * Description
 */
public class ReadFromProcess {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("javac");
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))
        ) {
            String buff = null;
            while ((buff = br.readLine()) != null) {
                System.out.println(buff);
            }
        }
    }
}
