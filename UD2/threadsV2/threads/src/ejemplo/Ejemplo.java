// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo {
   public Ejemplo() {
   }

   public static void main(String[] args) {
      List<String> cmd = new ArrayList();
      cmd.add("cmd.exe");
      cmd.add("dir");
      cmd.add("/c");
      ProcessBuilder pb = new ProcessBuilder(cmd);
      pb.redirectErrorStream(true);

      try {
         Process dir = pb.start();

         try {
            Throwable var4 = null;
            Object var5 = null;

            try {
               BufferedReader br = new BufferedReader(new InputStreamReader(dir.getInputStream()));

               try {
                  String line;
                  while ((line = br.readLine()) != null) {
                     System.out.println(line);
                  }

                  int valor = dir.waitFor();
                  int resultado = dir.exitValue();
                  System.out.println("Valor: " + valor);
                  System.out.println("Resultado: " + resultado);
               } finally {
                  if (br != null) {
                     br.close();
                  }

               }
            } catch (Throwable var19) {
               if (var4 == null) {
                  var4 = var19;
               } else if (var4 != var19) {
                  var4.addSuppressed(var19);
               }

               throw new InterruptedException();
            }
         } catch (InterruptedException var20) {
            var20.printStackTrace();
         }
      } catch (IOException var21) {
         var21.printStackTrace();
      }

   }
}
