public class App {
    public static void main(String[] args) {
        final int NUM_ACTIVOS = 10;
        final int NUM_ESPIAS = 1;
        Thread[] sumadores = new Thread[NUM_ACTIVOS];

        for (int i = 0; i < sumadores.length; i++) {
            sumadores[i] = new Thread(new Activo());
        }
        for (Thread t : sumadores) {
            t.start();
        }
    }
}
