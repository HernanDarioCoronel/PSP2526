package com.analisis;

public class Analizador {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int[] numeros = new int[args.length];
                for (int i = 0; i < args.length; i++) {
                    numeros[i] = Integer.parseInt(args[i]);
                }
                System.out.println(mayor(numeros));
                System.out.println(menor(numeros));
                System.out.println(promedio(numeros));
            } catch (NumberFormatException e) {
                System.out.println("Error: Todos los argumentos deben ser números enteros.");
                return;
            }

        } else {
            System.out.println("No se proporcionaron números para analizar.");
        }
    }

    public static int mayor(int[] array) {
        int mayor = array[0];
        for (int num : array) {
            if (num > mayor) {
                mayor = num;
            }
        }
        return mayor;
    }

    public static int menor(int[] array) {
        int menor = array[0];
        for (int num : array) {
            if (num < menor) {
                menor = num;
            }
        }
        return menor;
    }

    public static int promedio(int[] array) {
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        return suma / array.length;
    }
}
