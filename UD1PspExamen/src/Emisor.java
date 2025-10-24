import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Emisor {
    public static void main(String[] args) {
        String filePath = "emisor.txt";
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String contenido;
            while ((contenido = br.readLine()) != null) {
                System.out.println(contenido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
