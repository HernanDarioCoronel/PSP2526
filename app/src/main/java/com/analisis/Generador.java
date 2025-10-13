package com.analisis;

import java.util.Random;

public class Generador {
    public static void main(String[] args) {
        int length = 15;
        Random rand = new Random();
        if (args.length > 0) {
            try {
                length = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Se usará la longitud por defecto de 15.");
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(rand.nextInt(100));
        }
    }
}
