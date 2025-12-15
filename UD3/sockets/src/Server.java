import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    private static Logger logger = Logger.getAnonymousLogger();
    private static final int PORT = 9000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
                Socket socket = serverSocket.accept();
                BufferedReader serverIn = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
            while (true) {
                String line;
                while ((line = serverIn.readLine()) != null)
                    logger.info(line + " - " + socket.getRemoteSocketAddress());

                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
