package examples;

import java.util.Date;

public class Emisor {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Proceso escritor");
        Thread.sleep(1000);
        System.out.println(new Date().toString());
        Thread.sleep(1000);
    }
}



