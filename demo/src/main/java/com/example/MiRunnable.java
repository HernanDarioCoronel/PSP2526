package com.example;

public class MiRunnable implements Runnable{
    private String nombre;

    public MiRunnable(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + " - Contador: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(nombre + " Interrumpido");
            }
        }
        System.out.println(nombre + " Terminado");
    }

    
}
