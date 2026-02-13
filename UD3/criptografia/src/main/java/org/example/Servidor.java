package org.example;

import org.example.utils.AESFileEncryption;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {
        new File("documento.txt");
        final Logger logger = Logger.getAnonymousLogger();
        int puerto = 6000;
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor esperando en el puerto " + puerto);
            while (true) {
                try (Socket cliente = servidor.accept();
                     DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                     DataOutputStream salida = new DataOutputStream(cliente.getOutputStream())) {

                    String nombreArchivo = entrada.readUTF();
                    File file = new File(nombreArchivo);

                    if (file.exists()) {
                        byte[] contenido = Files.readAllBytes(file.toPath());
                        byte[] contenidoCifrado = AESFileEncryption.cifrar(contenido);

                        salida.writeInt(contenidoCifrado.length);
                        salida.write(contenidoCifrado);
                        System.out.println("Archivo " + nombreArchivo + " enviado y cifrado.");
                    } else {
                        logger.log(new LogRecord(Level.SEVERE, "Archivo no encontrado"));
                        salida.writeInt(-1);
                    }
                }
            }
        } catch (Exception e) {
            logger.log(new LogRecord(Level.SEVERE, e.getMessage()));
        }
    }
}