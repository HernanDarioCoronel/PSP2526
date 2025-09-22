package emisor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Emisor {
    public static void main(String[] args) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "src/receptor", "receptor.Receptor");
        Process process = processBuilder.start();
        String datos = "lorem ipsum dolor sit amet";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            PrintWriter pw = new PrintWriter(process.getOutputStream(), true);
            pw.println(datos);
        }

    }
}
