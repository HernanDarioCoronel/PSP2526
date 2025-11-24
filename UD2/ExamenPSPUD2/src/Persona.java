import java.util.Random;

public class Persona implements Runnable {
    private Discoteca discoteca;

    public Persona(Discoteca discoteca) {
        this.discoteca = discoteca;
    }

    @Override
    public void run() {
        Random rdn = new Random();
        while (true) {
            try {
                discoteca.entrar();
                Thread.sleep(rdn.nextInt(1000, 10000));
                discoteca.salir();
                Thread.sleep(rdn.nextInt(1000, 10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
