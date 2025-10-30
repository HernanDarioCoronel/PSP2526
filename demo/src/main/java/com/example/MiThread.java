package com.example;

public class MiThread extends Thread {
    private String nome;

    public MiThread(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nome + " - Contador: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(nome + " Interrumpido");
            }
        }
        System.out.println(nome + " Terminado");
    }
}
