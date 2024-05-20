package Task9;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Task implements Runnable {

    private double speed;
    String name;
    CyclicBarrier barrier;
    Semaphore semaphore;
    static int count = 0;

    public Task(double speed, String name, CyclicBarrier barrier, Semaphore semaphore) {
        this.speed = speed;
        this.name = name;
        this.barrier = barrier;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int distance = 200;
        double time = (distance / speed) * 100;
        try {

            if (count < 2) {
                barrier.await();
            }
            semaphore.acquire();

            System.out.println(name + " start");
            System.out.println(System.nanoTime());
            Thread.sleep((long) time);

            System.out.println(name + " end");
            System.out.println(System.nanoTime());

            if (count != 2) {
                count += 1;
            } else {
                count += 1;
                System.out.println("Победил: " + name);
            }
            semaphore.release();

        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
