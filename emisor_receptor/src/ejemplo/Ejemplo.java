public class Emisor {

    public static void main(String[] args) {

        String [] cmd = new String[]{"java", "-cp", "target/classes/", "Conversor"};
        final String FIN = "$FIN";
        final String[] TEXTO_ORIXINAL = new String[]{"ma", "me", "mi", "mo", "mu", FIN};
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(cmd);
            Process conversor = processBuilder.start();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conversor.getInputStream()));
            PrintWriter saida = new PrintWriter(new OutputStreamWriter(conversor.getOutputStream()), true);
            StringBuilder sb = new StringBuilder();
            for (String linhaSaida : TEXTO_ORIXINAL) {
                saida.println(linhaSaida);
                String linhaEntrada = entrada.readLine();
                sb.append(linhaEntrada);
            }
            System.err.println(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



public class Conversor {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //Importante autoflush = true ou ben writer.flush() despois de calque envío de datos
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
        StringBuffer stringBuffer = new StringBuffer();
        final String FIN_TEXTO = "$FIN";
        String linha = "";
        while (true){
            try {
                linha = bufferedReader.readLine();
                if (FIN_TEXTO.equalsIgnoreCase(linha)) {
                    System.err.println("Fin do envío de texto desde o emisor");
                    break;
                }
                //stringBuffer.append(linha);
                System.err.println(linha);
                writer.println(linha.toUpperCase(Locale.ROOT));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

