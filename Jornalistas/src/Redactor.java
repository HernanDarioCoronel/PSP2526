import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Redactor {
    public static void main(String[] args) {
        File file = new File("artigos.dat");
        if (!file.exists()) {
            System.err.println("O arquivo artigos.dat non existe");
            return;
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
                ObjectOutputStream outputStream = new ObjectOutputStream(System.out)) {
            Object object;
            while ((object = inputStream.readObject()) != null) {
                outputStream.writeObject(object);
            }
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
