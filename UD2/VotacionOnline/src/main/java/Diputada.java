import java.util.Random;

public class Diputada implements Runnable {

    public Votacion votacion;

    public Diputada(Votacion votacion) {
        this.votacion = votacion;
    }

    @Override
    public void run() {
        votacion.votar(new Random().nextInt(1, 3));
    }
}
