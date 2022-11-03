package tutes.oop3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedPool {
    private static int maxDivCount = 0;
    private static int associatedInt = 0;

    synchronized  static  void reportResult(int divCount, int assocInt) {
        if (divCount > maxDivCount) {
            maxDivCount = divCount;
            associatedInt = assocInt;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(8);
        // going to divide the task into 20 smaller ones
        for (int i = 19; i >= 0; i--) {
            es.execute(new MultiThreadedSimple.DivisorCounterThread(i * 10000 + 1, (i + 1) * 10000));
        }
        es.shutdown();
        try {
            es.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println("All threads finishes!");
        System.out.println(associatedInt + "has the most divisors between 1 and 20000");
        System.out.println("It has " + maxDivCount + " divisors");
        long finishTime = System.currentTimeMillis();
        System.out.println("Total: " + String.format("%.2f", (finishTime - startTime) / 1000.0) + "s");
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
        }
    }
}
