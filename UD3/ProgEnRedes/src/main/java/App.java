import messenger.Emisor;
import messenger.Receptor;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            Thread tReciever = new Thread(new Receptor(8080), "Reciever");
            Thread tSender = new Thread(new Emisor(8080), "Sender");

            tReciever.start();
            Thread.sleep(500);
            tSender.start();

            tSender.join();
            tReciever.join();
        } catch (IOException e) {
            System.err.println("Error de I/O al inicializar los sockets.");
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.err.println("La aplicación fue interrumpida.");
            throw new RuntimeException(e);
        }
    }
}
