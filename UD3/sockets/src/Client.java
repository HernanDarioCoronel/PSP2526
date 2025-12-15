import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Client {
    private final static int PORT = 9000;
    private final static String HOST = "localhost";

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT)) {
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream());
            int numVeces = 0;
            while (numVeces < 3) {
                serverOut.println(numVeces + " - Hola server! " + new Date());
                numVeces++;
                serverOut.flush();
            }
            serverOut.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
