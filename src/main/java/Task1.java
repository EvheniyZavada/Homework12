import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        AtomicLong counterOfSeconds = new AtomicLong(0l);
        executorService.scheduleAtFixedRate(() ->
                System.out.println(counterOfSeconds.incrementAndGet()), 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() ->
                System.out.println("Passed 5 sec"), 4, 5, TimeUnit.SECONDS);
    }
}



