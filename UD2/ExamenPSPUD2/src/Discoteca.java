public class Discoteca {
    private int aforo;
    private int maxAforo;
    private boolean entroJenniffer;
    private boolean intentaEntrarCliente;
    private boolean intentaSalirCliente;

    public Discoteca(int maxAforo) {
        this.aforo = 0;
        this.entroJenniffer = false;
        this.intentaEntrarCliente = false;
        this.intentaSalirCliente = false;
        this.maxAforo = maxAforo;
    }

    public synchronized void abrir() {
        System.out.println("Jennifer en la puerta, ¡Empezamos! 0 personas dentro.");
        entroJenniffer = true;
    }

    public synchronized void entrar() {
        while (aforo == maxAforo
                || !entroJenniffer
                || intentaEntrarCliente
                || intentaSalirCliente) {
            try {
                System.out.println("Cliente "
                        + Thread.currentThread().getName()
                        + " intenta entrar - "
                        + aforo
                        + " de "
                        + maxAforo
                        + " personas dentro");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        intentaEntrarCliente = true;
        aforo++;
        System.out.println("Cliente "
                + Thread.currentThread().getName()
                + " entró - "
                + aforo
                + " de "
                + maxAforo
                + " personas dentro");
        intentaEntrarCliente = false;
        notifyAll();
    }

    public synchronized void salir() {
        while (!entroJenniffer
                || intentaEntrarCliente
                || intentaSalirCliente) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        intentaSalirCliente = true;
        aforo--;
        System.out.println("Cliente "
                + Thread.currentThread().getName()
                + " sale - "
                + aforo
                + " de "
                + maxAforo
                + " personas dentro");
        intentaSalirCliente = false;
        notifyAll();
    }
}
