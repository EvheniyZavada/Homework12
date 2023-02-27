import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//МОЁ НЕВЕРНОЕ РЕШЕНИЕ

public class Task2 {
    public static void main(String[] args) {
        AtomicInteger number = new AtomicInteger(20);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        while (number.get() > 0) {
            if (number.get() % 15 == 0) {
                executorService.scheduleAtFixedRate(() -> System.out.println("fizzbuzz"), 0, 1, TimeUnit.SECONDS);
                number.getAndDecrement();
                Thread.currentThread().notifyAll();
            }else {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (number.get() % 3 == 0 && number.get() % 5 != 0) {
                executorService.scheduleAtFixedRate(() -> System.out.println("fizz"), 0, 1, TimeUnit.SECONDS);
                number.getAndDecrement();
                Thread.currentThread().notifyAll();
            }else {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (number.get() % 5 == 0 && number.get() % 3 != 0) {
                executorService.scheduleAtFixedRate(() -> System.out.println("buzz"), 0, 1, TimeUnit.SECONDS);
                number.getAndDecrement();
                Thread.currentThread().notifyAll();
            }else {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (number.get() % 5 != 0 && number.get() % 3 != 0){
                executorService.scheduleAtFixedRate(() -> System.out.println(number.get()), 0, 1, TimeUnit.SECONDS);
                number.getAndDecrement();
                Thread.currentThread().notifyAll();
            }else {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
