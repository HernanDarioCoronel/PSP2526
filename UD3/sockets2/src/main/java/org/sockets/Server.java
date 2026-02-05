package org.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 9000;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT); Socket socket = serverSocket.accept(); DataInputStream dis = new DataInputStream(socket.getInputStream()); DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            try {
                byte[] linea = new byte[128];
                int numBytes = dis.readNBytes(linea, 0, linea.length);
                System.out.println(new String(linea, 0, numBytes));
                dos.write(linea, 0, numBytes);
                dos.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}
