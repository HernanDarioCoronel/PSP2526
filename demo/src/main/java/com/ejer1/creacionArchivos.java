package com.ejer1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class creacionArchivos {
    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            File file = new File("file" + i + ".txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                
            } catch (Exception e) {
                e.printStackTrace();
            } 

        }
    }
}
