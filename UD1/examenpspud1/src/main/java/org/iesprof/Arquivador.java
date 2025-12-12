package org.iesprof;

import java.io.*;

public class Arquivador {
    public static void main(String[] args) {
        String[] cmd = {"Java", "-cp", "target", "Emisor"};
        String filePathEmisor = "emisor.txt";
        String filePath = "arquivador.txt";
        File fileEmisor = new File(filePathEmisor);
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ProcessBuilder pb = new ProcessBuilder(cmd);

        try {
            Process processEmisor = pb.start();
            InputStreamReader isr = new InputStreamReader(processEmisor.getInputStream());
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

            int contenido;
            while ((contenido = isr.read()) != -1) {
                bw.write(contenido);
            }
        }
        catch (IOException e ){
            e.printStackTrace();
        }
    }
}

