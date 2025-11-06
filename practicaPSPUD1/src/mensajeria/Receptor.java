package mensajeria;

import java.io.*;

public class Receptor {
    public static void main(String[] args) {
        File outputFile = new File("datos.bin");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("datos.bin"))) {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }
}
