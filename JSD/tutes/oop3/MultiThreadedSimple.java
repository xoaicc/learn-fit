package tutes.oop3;

/**
 * Need to define a subtype of Thread
 * It doesn't need to be a separate class
 */

public class MultiThreadedSimple {

    private static int maxDivCount = 0;
    private static int associatedInt = 0;

    synchronized  static  void reportResult(int divCount, int assocInt) {
        if (divCount > maxDivCount) {
            maxDivCount = divCount;
            associatedInt = assocInt;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] workers = new Thread[8];
        for (int i = 0; i < workers.length; i++) {
            // if i == 0, the thread starts from 1 to 24999
            // if i == 1, the thread starts from 25001 to 49999
            workers[i] = new DivisorCounterThread(i * 25000 + 1, (i + 1) * 25000 - 1);
            workers[i].start();
        }
        for (Thread t : workers) {
            t.join();
        }
        System.out.println("All threads finishes!");
        System.out.println(associatedInt + "has the most divisors between 1 and 20000");
        System.out.println("It has " + maxDivCount + " divisors");
    }

    public static class DivisorCounterThread extends Thread {
        private int from;
        private int to;

        public DivisorCounterThread(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            int maxDivisorCount = 0;
            int theAssociatedNumber = 0;
            for (int N = from; N < to; N++) {
                int count = SingleThreaded.countDivisors(N);
                if (count > maxDivisorCount) {
                    maxDivisorCount = count;
                    theAssociatedNumber = N;
                }
            }
            // TODO: report the result
            reportResult(maxDivisorCount, theAssociatedNumber);
            long finishTime = System.currentTimeMillis();
            System.out.println("Thread (" + from + ":" + to + ") finish after " + String.format("%.2f", (finishTime - startTime) / 1000.0) + "s");
        }
    }
}
