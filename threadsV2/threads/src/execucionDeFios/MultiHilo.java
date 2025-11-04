package execucionDeFios;

public class MultiHilo {
    public Thread[] hilos;
    public int count = 0;

    public MultiHilo(int cantidad) {
        hilos = new Thread[cantidad];
        Dato dato = new Dato();
        for (int i = 0; i < cantidad; i++) {
            hilos[i] = new Thread(new RunnableTask("Thread-" + i, dato));
        }
    }

    public void infinito() {
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}
