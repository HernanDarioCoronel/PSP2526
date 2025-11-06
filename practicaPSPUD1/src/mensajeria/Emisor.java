package mensajeria;

import java.io.*;

public class Emisor {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "out/production/practica1", "mensajeria.Receptor");
        try {
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process process = processBuilder.start();
            OutputStream outputStream = process.getOutputStream();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("datos.txt"));
                 PrintWriter printWriter = new PrintWriter(outputStream, true)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    printWriter.println(line);
                }
            }
            int exitCode = process.waitFor();
            System.out.println("Mensajeria.Receptor finished with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
