import Threads.happyEvenThread;
import Threads.happyOddThread;

public class Main {
    public static void main (String[] args) {

        happyOddThread oddThread = new happyOddThread();

        Runnable happyEvenThread = new happyEvenThread();
        Thread evenThread = new Thread(happyEvenThread);

        evenThread.start();
        oddThread.start();

    }
}
