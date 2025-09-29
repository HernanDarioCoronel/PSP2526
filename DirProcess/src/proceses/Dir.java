package proceses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dir {
    public static void main(String[] args) throws InterruptedException, IOException {
        String[] command = {"nslookup ", "www.xunta.gal"};

        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String output;
        while (true) {
            output = br.readLine();
            if (output == null)
                break;
            System.out.println(output);
        }
        process.waitFor();
        System.out.println("Exit value:" + process.exitValue());
    }
}
