package com.analisis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controlador {
    public static void main(String[] args) {
        final String ruta = "target/classes";
        int length = 15;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese la cantidad de números a generar: (default 15)");
            length = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Se usará la longitud por defecto de 15.");
        }

        ProcessBuilder generador = new ProcessBuilder("java", "-cp", ruta, "com.analisis.Generador",
                String.valueOf(length));
        ProcessBuilder analizador = new ProcessBuilder("java", "-cp", ruta, "com.analisis.Analizador");
        try {
            Process generadorProcess = generador.start();
            Process analizadorProcess = analizador.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(generadorProcess.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(generadorProcess.getErrorStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                analizadorProcess.getOutputStream().write((line + "\n").getBytes());
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
