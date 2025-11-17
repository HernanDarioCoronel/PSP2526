public class Espia implements Runnable{
    Caixa caixa;
    public Espia(Caixa caixa){
        this.caixa = caixa;
    }


    @Override
    public void run() {
        this.caixa.retirar();
    }
}
