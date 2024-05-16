package Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Execute {

    public static void main(String[] args) {

        ArrayList<Integer> threads = new ArrayList<>();
        threads.add(1);
        threads.add(2);
        threads.add(4);
        threads.add(8);

        long number = 1000000000;

        for (int n: threads) {

            long startTime = System.nanoTime();

            System.out.println("Количество потоков: " + n);
            ExecutorService service = Executors.newFixedThreadPool(n);
            ArrayList<Task> tasks = new ArrayList<>();

            int ip = 1;
            System.out.println("Разбиения числа: ");
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    tasks.add(new Task(0, i * (number / n)));
                    System.out.println(0 + " " + i * (number / n));

                } else {
                    tasks.add(new Task(ip * (number / n) + 1, i * (number / n)));
                    System.out.println(ip * (number / n) + 1 + " " + i * (number / n));
                }
                ip = i;
            }

            List<Future<Long>> results;
            try {
                results = service.invokeAll(tasks);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            long result = 0;
            for (Future<Long> i: results) {
                try {
                    result += i.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("Сумма: " + result);

            service.shutdown();

            long endTime = System.nanoTime();
            System.out.println("Время выполнения: " + (endTime - startTime) / 1000000 + "ms");
            System.out.println();

        }
    }
}
