package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Receptor {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] cmd = {"java", "-cp", "out/production/DirProcess/examples/", "Emisor"};
        ProcessBuilder pb = new ProcessBuilder(cmd);
        Process editor = pb.start();
        Thread.sleep(1000);
        //BufferedReader br = new BufferedReader(new InputStreamReader());

    }
}
