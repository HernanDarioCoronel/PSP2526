package messenger;

import utils.AnsiColor;
import utils.ColorLogger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Emisor implements Runnable {
    private final int port;
    private final String host;

    public Emisor(int port, String host) throws IOException {
        ColorLogger.printLine(AnsiColor.MAGENTA, "Iniciando Emisor");
        this.port = port;
        this.host = host;
    }

    /**
     * Default
     * puerto = 12345
     * host = localhost
     */
    public Emisor() throws IOException {
        this(12345, "localhost");
    }

    /**
     * Default
     * host = localhost
     */
    public Emisor(int port) throws IOException {
        this(port, "localhost");
    }

    /**
     * Default
     * puerto = 12345
     */
    public Emisor(String host) throws IOException {
        this(12345, host);
    }


    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket(this.host, this.port)) {
            ColorLogger.print(AnsiColor.CIAN, "Conexión del emisor exitosa en el puerto: ");
            System.out.println(port);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            ColorLogger.printLine(AnsiColor.BLANCO, "Escribe mensajes y presiona ENTER para enviarlos:");

            while (true) {
                if (socket.isClosed() || socket.isOutputShutdown()) {
                    ColorLogger.printLine(AnsiColor.ROJO, "Conexión de envío cerrada.");
                    break;
                }
                ColorLogger.print(AnsiColor.VERDE, "-: ");
                String toSend = scanner.nextLine();
                if (toSend.length() > 1) {
                    out.write(toSend);
                    out.newLine();
                    out.flush();
                }
            }
        } catch (IOException e) {
            ColorLogger.printLine(AnsiColor.ROJO, "Ocurrió un problema:");
            e.printStackTrace();
        }
    }
}
