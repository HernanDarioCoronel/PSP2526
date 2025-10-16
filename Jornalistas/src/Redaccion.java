import java.io.EOFException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

public class Redaccion {

    public static void main(String[] args) {
        String[] cmdEscritor = new String[] { "java", "-cp", "bin/", "Redactor" }; // Pode variar co editor
        List<Artigo> artigos = null;
        ProcessBuilder redactor = new ProcessBuilder(cmdEscritor);
        try {
            Process procesoRedactor = redactor.start();
            procesoRedactor.waitFor();
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(procesoRedactor.getInputStream());
                Object object;
                while ((object = objectInputStream.readObject()) != null) {
                    @SuppressWarnings("unchecked")
                    List<Artigo> temp = (List<Artigo>) object;
                    artigos = temp;
                }
            } catch (EOFException e) {
                // Ignorar excepción de fin de arquivo
            } catch (Exception e) {
                e.printStackTrace();
            }
            procesoRedactor.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Necesito instanciar unha clase ProcessBuilder para lanzar outro proceso que
        // inicie o .class Redactor
        // Debemos conectar o fluxo de entrada do proceso redactor.getInputStream()
        // cunha instancia de ObjectInputStream para ler os obxectos enviados por
        // Redactor
        // Os obxectos recebidos polo fluxo ObjectInputStream deben ser convertidos a
        // Artigo, xa que son simples Object
        // ...

        // Finalmente, imprimimos na console do sistema todos os artigos enviados por
        // Redactor
        System.out.println("Edición da revista de ".concat(new Date().toString()));
        artigos.forEach(a -> System.out.println(a.toString()));
    }
}