public class Activo implements Runnable {
    private Caixa caixa;

    public Activo() {
        caixa = new Caixa();
    }

    @Override
    public void run() {
        while (true) {
            int n = (int) Math.random() * 10;
            this.caixa.anotar("Hola Mundo"); //.suma(n);
        }
    }
}
