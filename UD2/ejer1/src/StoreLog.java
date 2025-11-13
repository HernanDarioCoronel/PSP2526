public class StoreLog {
    private Thread[] fios;
    private int min;
    private int max;

    public StoreLog(int min, int max) {
        this.min = min;
        this.max = max;
        this.fios = new Thread[]{
                new Thread(new RunnableTask(min, max)),
                new Thread(new RunnableTask(min, max)),
                new Thread(new RunnableTask(min, max))
        };
    }

    public void start(){
        for(Thread t : fios){
            t.start();
        }
    }

    public Thread[] getFios() {
        return fios;
    }

    public void setFios(Thread[] fios) {
        this.fios = fios;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
