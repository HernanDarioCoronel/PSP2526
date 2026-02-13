package org.example;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        String archivoSolicitado = "documento.txt";

        try (Socket socket = new Socket(host, puerto);
             DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
             DataInputStream entrada = new DataInputStream(socket.getInputStream())) {

            salida.writeUTF(archivoSolicitado);

            int longitud = entrada.readInt();
            if (longitud != -1) {
                byte[] datosCifrados = new byte[longitud];
                entrada.readFully(datosCifrados);

                String nombreDestino = archivoSolicitado + "enc";
                try (FileOutputStream fos = new FileOutputStream(nombreDestino)) {
                    fos.write(datosCifrados);
                }
                System.out.println("Archivo recibido y guardado como: " + nombreDestino);
            } else {
                System.out.println("El archivo no existe en el servidor.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
