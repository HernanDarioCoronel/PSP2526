import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        System.out.print("Ip a consultar: 8.8.8.8 (google.com)\n");
        String ip = "8.8.8.8";

        System.out.print("Cantidad de paquetes: 5\n");
        int packets = 5;

        try {
            ProcessBuilder pb = new ProcessBuilder("ping", "-n", String.valueOf(packets), ip);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder outputBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                outputBuilder.append(line).append("\n");
            }

            process.waitFor();

            String output = outputBuilder.toString();
            int transmitted = 0;
            int received = 0;
            double loss = 0;
            double avgMs = 0;

            String[] lines = output.split("\n");
            for (String currentLine : lines) {
                currentLine = currentLine.trim();

                if (currentLine.startsWith("Paquetes:")) {
                    String[] parts = currentLine.split(",");
                    transmitted = Integer.parseInt(parts[0].replaceAll("\\D+", ""));
                    received = Integer.parseInt(parts[1].replaceAll("\\D+", ""));
                    loss = Double.parseDouble(parts[2].replaceAll("\\D+", ""));
                }
                else if (currentLine.contains("Media =")) {
                    String average = currentLine.replaceAll(".*Media = (\\d+).*", "$1");
                    avgMs = Double.parseDouble(average);
                }
            }

            System.out.println("\n--- Resultado ---");
            System.out.println("Retraso promedio: " + avgMs + " ms");
            System.out.println("Paquetes transmitidos: " + transmitted);
            System.out.println("Paquetes recibidos: " + received);
            System.out.println("Pérdida: " + loss + "%");

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
