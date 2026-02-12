package dam.dual;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    private static final String HOST = "localhost";
    private static final int PUERTO = 5000;

    public static void main(String[] args) {
        String archivoSolicitado = "Exercicio 2.1 Spring Boot_DDD.pdf";


        try (Socket socket = new Socket(HOST, PUERTO);
             DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
             DataInputStream entrada = new DataInputStream(socket.getInputStream());
             Scanner sc = new Scanner(System.in)
        ) {
            /*
                System.out.println("Ingrese el archivo que desea descargar: ");
                archivoSolicitado = sc.nextLine();
            */
            salida.writeUTF(archivoSolicitado);

            boolean existe = entrada.readBoolean();

            if (existe) {
                long tamano = entrada.readLong();
                System.out.println("Descargando " + archivoSolicitado + " (" + tamano + " bytes)...");

                try (FileOutputStream fos = new FileOutputStream(archivoSolicitado)) {
                    byte[] buffer = new byte[4096];
                    int bytesLeidos;
                    long totalRecibido = 0;

                    while (totalRecibido < tamano && (bytesLeidos = entrada.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesLeidos);
                        totalRecibido += bytesLeidos;
                    }
                }
                System.out.println("Archivo guardado correctamente.");
            } else {
                System.out.println("El servidor informa que el archivo no existe.");
            }

        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
}
