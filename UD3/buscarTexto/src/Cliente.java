import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    private static final int PORT = 9001;
    private static final String HOST = "localhost";
    private static final String[] COSAS = new String[]{"Leucemia", "Jarrones", "SIDA"};

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
            int intentos = 0;
            while (intentos <= 2) {
                System.out.println("Escriba algo para buscar....");
                printWriter.println(COSAS[intentos]);
                intentos++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
