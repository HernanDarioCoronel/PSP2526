import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConectividadIP {
    public static void main(String[] args) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("ping", "-n", "4", "172.16.205.12");

        try{
            Process process = processBuilder.start();
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

