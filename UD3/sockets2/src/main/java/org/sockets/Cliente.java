package org.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Cliente {

    private static final int PORT = 9000;
    private static final String HOST = "localhost";

    public static void main(String[] args) {

        try (
                Socket socket = new Socket(HOST, PORT);
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            InetAddress address = Inet4Address.getByName(HOST);
            String msg = "Hola mundo";
            dos.write(msg.getBytes(StandardCharsets.UTF_8));
            dos.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
