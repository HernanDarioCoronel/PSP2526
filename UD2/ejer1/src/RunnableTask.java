import java.util.Random;

public class RunnableTask implements Runnable {
    private int minRange;
    private int maxRange;

    public RunnableTask(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    @Override
    public void run() {
        Random rdn = new Random();
        while (true) {
            System.out.println(rdn.nextInt(minRange, maxRange));
        }
    }
}
