import java.math.BigInteger;

/**
 * This examples shows how to terminate a thread which DOES NOT HANDLE INTERRUPT SIGNALS
 * 
 * A "Daemon" is unimportant - if only thing running, JVM will exit
 * 
 * A non-daemon thread will keep going even if there is an interrupt signal, unless the thread
 * is checking for the interrupt signal and then does something to handle it, like return
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main3 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("100000000")));

        thread.setDaemon(false); // if not a daemon, is, what, a DEMON? JVM keeps running if running
        thread.setDaemon(true); // make the thread a sub lol - if only thing running, JVM exits
        thread.start();
        Thread.sleep(100);
        // thread.interrupt();  // thread.interrupt irrelevant when the only thread is a daemon
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }

            return result;
        }
    }
}
