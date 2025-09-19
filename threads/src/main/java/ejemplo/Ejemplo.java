package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo {
    public static void main(String[] args) {
        List<String> cmd = new ArrayList<>();

        cmd.add("cmd.exe");
        cmd.add("dir");
        cmd.add("/c");
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);

        try {
            Process dir = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(dir.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                int valor = dir.waitFor();
                int resultado = dir.exitValue();
                System.out.println("Valor: " + valor);
                System.out.println("Resultado: " + resultado);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
