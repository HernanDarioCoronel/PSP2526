package dam.dual;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Servidor {
    private static final Logger logger = Logger.getAnonymousLogger();
    private static final int PUERTO = 5000;
    private static final String DIRECTORIO_RECURSOS = "servidor_archivos/";

    public static void main(String[] args) {
        //new File(DIRECTORIO_RECURSOS).mkdirs();
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            //noinspection InfiniteLoopStatement
            while (true) {
                try (Socket socketCliente = serverSocket.accept()) {
                    DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
                    DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

                    String nombreRecurso = entrada.readUTF();
                    File fichero = new File(DIRECTORIO_RECURSOS + nombreRecurso);

                    if (fichero.exists() && !fichero.isDirectory()) {
                        salida.writeBoolean(true);
                        salida.writeLong(fichero.length());

                        try (FileInputStream fis = new FileInputStream(fichero)) {
                            byte[] buffer = new byte[4096];
                            int bytesLeidos;
                            while ((bytesLeidos = fis.read(buffer)) != -1) {
                                salida.write(buffer, 0, bytesLeidos);
                            }
                        }
                        System.out.println("Archivo " + nombreRecurso + " enviado con éxito.");

                        registrarOperacion(socketCliente, nombreRecurso);
                    } else {
                        salida.writeBoolean(false);
                        System.out.println("Recurso no encontrado: " + nombreRecurso);
                    }
                } catch (IOException e) {
                    System.err.println("Error en la sesión con el cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            logger.log(new LogRecord(Level.SEVERE, e.getMessage()));

        }
    }

    private static void registrarOperacion(Socket socket, String recurso) {
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String ipCliente = socket.getInetAddress().getHostAddress();
        int puertoCliente = socket.getPort();

        String lineaLog = String.format("%s_%s_%d_%s", fechaHora, ipCliente, puertoCliente, recurso);

        try (PrintWriter logWriter = new PrintWriter(new FileWriter("streamsockets.log", true))) {
            logWriter.println(lineaLog);
        } catch (IOException e) {
            System.err.println("Error al escribir en el log: " + e.getMessage());
        }
    }
}
