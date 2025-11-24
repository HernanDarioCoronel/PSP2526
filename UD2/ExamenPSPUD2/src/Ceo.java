public class Ceo implements Runnable{
    Discoteca discoteca;

    public Ceo(Discoteca discoteca) {
        this.discoteca = discoteca;
    }


    @Override
    public void run() {
        discoteca.abrir();
    }
}
