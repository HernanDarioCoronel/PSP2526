package pasd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyReader {

    public static void main(String[] args) {
        String filePath = "personas.csv";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "out/production/practica1", "pasd.MyWriter");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            Process process = pb.start();
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            String line;
            List<Persona> personas = new ArrayList<>();
            boolean firstTime = true;
            while ((line = br.readLine()) != null) {
                if (firstTime) {
                    firstTime = false;
                    continue;
                }
                String[] datos = line.split(";");
                personas.add(new Persona(
                        datos[0],
                        datos[1],
                        Integer.parseInt(datos[2])
                ));
            }
            OutputStream os = process.getOutputStream();

            try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
                for (Persona p : personas) {
                    oos.writeObject(p);
                }
                oos.flush();
            }
            int exitResult = process.waitFor();
            System.out.println("Process terminated. Exit Result: " + exitResult);
        } catch (InterruptedException | NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}