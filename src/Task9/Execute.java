package Task9;

import java.util.ArrayList;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Execute {

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(2);
        Semaphore semaphore = new Semaphore(2);

        ArrayList<Double> speeds = new ArrayList<>();
        speeds.add(3.5);
        speeds.add(2.7);
        speeds.add(4.8);
        speeds.add(5.9);

        new Thread(new Task(speeds.get(0), "sportacus11", barrier, semaphore)).start();
        new Thread(new Task(speeds.get(1), "sportacus21", barrier, semaphore)).start();

        Thread.sleep(100);

        if (speeds.get(0) >= speeds.get(1)) {

            new Thread(new Task(speeds.get(3), "sportacus22", barrier, semaphore)).start();
            Thread.sleep(100);
            new Thread(new Task(speeds.get(2), "sportacus12", barrier, semaphore)).start();

        } else {

            new Thread(new Task(speeds.get(2), "sportacus12", barrier, semaphore)).start();
            Thread.sleep(200);
            new Thread(new Task(speeds.get(3), "sportacus22", barrier, semaphore)).start();

        }
    }
}
