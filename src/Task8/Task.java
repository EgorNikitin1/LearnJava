package Task8;

import java.util.concurrent.Callable;

public class Task implements Callable<Long> {

    private long a;
    private long b;

    public Task(long a, long b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (long i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }
}
