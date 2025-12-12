package utils;

public class ThreadManager {

    public void lock() throws InterruptedException {
        wait();
    }

    public void unlock(){
        notifyAll();
    }
}
