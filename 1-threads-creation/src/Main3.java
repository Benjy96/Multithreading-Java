/**
 * Threads Creation - Part 1, Thread Capabilities & Debugging
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main3 {

    public static void main(String [] args) {

        Thread thread1 = new TaskThread1();             // extends Thread, so can just make new Thread
        Thread thread2 = new Thread(new TaskThread2()); // implements Runnable - new Thread, giving
                                                            // a Runnable object target

        System.out.println("Starting threads");

        thread1.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();

        System.out.println("Threads started");

    }

    public static class TaskThread1 extends Thread {
        @Override
        public void run(){
            System.out.println("extends thread");
        }
    }

    public static class TaskThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("implements runnable");
        }
    }

}
