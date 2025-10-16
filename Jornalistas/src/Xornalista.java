import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Xornalista {
    /**
     * Os xornalistas dunha revista dispoñen dun programa de escritorio que envía
     * una lista de artigos a un proceso, tamén local, que os trata convenientemente
     * e os publica. Para nós esta tarefa consistirá en visualizalos na terminal do
     * proceso que os recebe, que denominaremos Redaccion.
     * A lista de artigos debe estar no arquivo de disco "artigo.dat".
     * 
     * COMPLETA O CÓDIGO DAS SEGUINTES CLASES SEGUNDO SEXA NECESARIO
     * Non alteres a nomenclatura empregada.
     * 
     */

    public static void main(String[] args) throws Exception {

        Artigo artigo1 = new Artigo(new Date(), "Está la cosa jodía", "María Remedios", "opinión");
        Artigo artigo2 = new Artigo(new Date(), "Está la cosa peó", "María Remedios", "opinión");
        Artigo artigo3 = new Artigo(new Date(), "Está la cosa fatá", "María Remedios", "opinión");
        Artigo artigo4 = new Artigo(new Date(), "Está la cosa xunga", "María Remedios", "opinión");

        List<Artigo> artigos = new ArrayList<>();
        artigos.add(artigo1);
        artigos.add(artigo2);
        artigos.add(artigo3);
        artigos.add(artigo4);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("artigos.dat"));
        objectOutputStream.writeObject(artigos);
        objectOutputStream.flush();
        objectOutputStream.close();

        // Necesitamos unha operación con ObjectInputStream que recupere a información
        // salvada no disco
        // para reconstruir o tipo da lista, dado que non é List<Artigo>
        // ...

        // ObjectInputStream objectInputStream = new ObjectInputStream(new
        // FileInputStream("artigos.dat"));
        // List<Artigo> objects = (List<Artigo>) objectInputStream.readObject();
        // Necesitamos enviar a información da lista de obxectos Artigo polo fluxo de
        // saída do proceso actual
        // mais enviando obxectos, non bytes ou simples String's. Por iso debemos
        // instanciar ObjectOutputStream
        // iterar a lista e ilos enviando polo fluxo.
        // ....
    }
}