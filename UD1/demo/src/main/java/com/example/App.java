package com.example;

public class App {
    public static void main(String[] args) {
        MiThread t1 = new MiThread("Pepito");
        MiThread t2 = new MiThread("José");

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread t3 = new Thread(new MiRunnable("Runnable1"));
        Thread t4 = new Thread(new MiRunnable("Runnable2"));

        System.out.println("Usando runnables con lambda");
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda-thread - Contador: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t5.start();

        try {
            t3.join();
            t4.join();
            t5.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n=== TODOS OS FIOS TERMINADOS");
    }
}
