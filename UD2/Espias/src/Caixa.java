public class Caixa {
    private int valor;
    private String secreto;
    private boolean ocupado;
    private boolean retirado;

    public Caixa() {
        valor = 0;
        secreto = "";
        ocupado = false;
        retirado = false;
    }

    public synchronized int suma(int n) {
        System.out.println(Thread.currentThread().getName() + " entra na caixa");
        int temporal = this.valor;
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        temporal += n;
        this.valor = temporal;
        System.out.println(Thread.currentThread().getName() + " sae na caixa");
        return this.valor;
    }

    public synchronized void anotar(String mensaje) {
        String temporal;
        System.out.println(Thread.currentThread().getName() + " entra na caixa");
        while (ocupado || !retirado) {
            try {
                System.out.println("Se bloquea");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ocupado = true;
        retirado = false;
        temporal = mensaje;
        this.secreto = temporal;
        System.out.println(Thread.currentThread().getName() + " sae na caixa");
        ocupado = false;
        notifyAll();
    }

    public synchronized void retirar() {
        String temporal;
        System.out.println(Thread.currentThread().getName() + " espía entra na caixa");
        while (ocupado || retirado) {
            try {
                System.out.println("Espía se bloquea");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ocupado = true;
        retirado = true;
        System.out.println(Thread.currentThread().getName() + " espía sae na caixa");
        ocupado = false;
        notifyAll();
    }
}
