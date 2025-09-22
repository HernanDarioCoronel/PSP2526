package receptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;

public class Receptor {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
        StringBuffer stringBuffer = new StringBuffer();
        final String FIN_TEXTO = "$FIN";
        String linha = "";
        while (true) {
            try {
                linha = bufferedReader.readLine();
                if (FIN_TEXTO.equalsIgnoreCase(linha)) {
                    System.err.println("Fin do envío de texto desde o emisor");
                    break;
                }
                // stringBuffer.append(linha);
                System.err.println(linha);
                writer.println(linha.toUpperCase(Locale.ROOT));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
