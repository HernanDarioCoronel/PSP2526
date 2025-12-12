package execucionDeFios;

public class RunnableTask implements Runnable {

    private String name;
    private Dato dato;

    public RunnableTask(String name, Dato dato) {
        this.name = name;
        this.dato = dato;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(name + " " + dato.sumar());
        }
    }

}
