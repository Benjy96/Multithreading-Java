/**
 *  Threads Creation - Part 1, Thread Capabilities & Debugging
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main1 {

    public static void main(String[] args) {

        // create a thread object, but don't run it yet
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in  a new thread
                System.out.println("we are now in thread " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });

        // set thread name
        thread.setName("New Worker Thread");

        // OS Sets "Dynamic Priority" = Static + Bonus
        // We can set the Static priority below:
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println(Thread.currentThread().getName()+ " before starting a new thread");
        thread.start();
        System.out.println(Thread.currentThread().getName()+ " after starting a new thread");
    }
}
