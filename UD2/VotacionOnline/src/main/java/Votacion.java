public class Votacion {
    public static int A_FAVOR = 0;
    public static int EN_CONTRA = 0;
    public static int abstenciones = 0;
    public boolean estaVotando;

    public synchronized void votar(int voto) {
        try {
            if (estaVotando) {
                wait();
            } else {
                estaVotando = true;
            }
            switch (voto) {
                case 1:
                    A_FAVOR++;
                    break;
                case 2:
                    EN_CONTRA++;
                    break;
                default:
                    abstenciones++;
            }
            estaVotando = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String resultado(){
        return "RESULTADOS: \n"+
                "A FAVOR: " + A_FAVOR + "\n" +
                "EN CONTRA";
    }
}
