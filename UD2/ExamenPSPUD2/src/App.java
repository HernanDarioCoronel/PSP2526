import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final int AFORO = 5;
        final int GENTE = 10;
        Discoteca discoteca = new Discoteca(AFORO);
        Ceo jennifer = new Ceo(discoteca);
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= GENTE; i++) {
            threads.add(new Thread(new Persona(discoteca), "" + i));
        }
        threads.add(new Thread(jennifer, "jennifer"));

        for (Thread t : threads) {
            t.start();
        }
    }
}
