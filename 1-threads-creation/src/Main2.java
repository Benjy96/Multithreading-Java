/**
 * Threads Creation - Part 1, Thread Capabilities & Debugging
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main2 {

    public static void main(String [] args) {

        // One of the ways to make a thread is to create a Runnable object
        // Alternate way is to extend Thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in a new thread
                throw new RuntimeException("Intentional Exception");
            }
        });

        thread.setName("Misbehaving thread");

        // create an exception handler for our thread to print the exception
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName()
                        + " the error is " + e.getMessage());
            }
        });

        thread.start();

    }

}
