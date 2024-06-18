package Threads;
public class happyOddThread extends Thread {
    @Override
    public void run () {
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.print("\u001B[31m"+ i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
