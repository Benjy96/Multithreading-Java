/**
 * Thread Termination & Daemon Threads
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main1 {
    public static void main(String [] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500_000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }
        }
    }
}
