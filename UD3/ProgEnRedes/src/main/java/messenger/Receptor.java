package messenger;

import utils.AnsiColor;
import utils.ColorLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Receptor implements Runnable {
    private final int port;
    private final ServerSocket serverSocket;

    public Receptor(int port) throws IOException {
        ColorLogger.printLine(AnsiColor.MAGENTA, "Iniciando Receptor");
        this.port = port;
        this.serverSocket = new ServerSocket(port);
    }

    /**
     * Default
     * puerto = 12345
     */
    public Receptor() throws IOException {
        this(12345);
    }

    @Override
    public void run() {
        try (Socket clienteSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()))
        ) {
            ColorLogger.print(AnsiColor.CIAN, "Conexión del receptor exitosa en el puerto: ");
            System.out.println(port);

            String recieved;
            while (true) {
                recieved = in.readLine();

                if (!recieved.trim().isEmpty()) {
                    ColorLogger.print(AnsiColor.CIAN, "-: ");
                    System.out.println(recieved);
                }
            }
        } catch (IOException e) {
            ColorLogger.printLine(AnsiColor.ROJO, "Ocurrió un problema:");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
        }
    }
}

