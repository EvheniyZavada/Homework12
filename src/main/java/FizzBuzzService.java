import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzService {
    private final int n = 15;
    AtomicInteger number = new AtomicInteger(1);

    public synchronized void fizz() {
        while (number.get() <= n){
            if (number.get() % 3 == 0 && number.get() % 5 != 0){
                System.out.println("fizz");
                number.incrementAndGet();
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public synchronized void buzz() {
        while (number.get() <= n){
            if (number.get() % 5 == 0 && number.get() % 3 != 0){
                System.out.println("buzz");
                number.incrementAndGet();
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public synchronized void fizzbuzz() {
        while (number.get() <= n){
            if (number.get() % 15 == 0){
                System.out.println("fizzbuzz");
                number.incrementAndGet();
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public synchronized void number() {
        while (number.get() <= n){
            if (number.get() % 5 != 0 && number.get() % 3 != 0 ){
                System.out.println(number.get());
                number.incrementAndGet();
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        FizzBuzzService fizzBuzzService = new FizzBuzzService();
        service.submit(fizzBuzzService::fizz);
        service.submit(fizzBuzzService::buzz);
        service.submit(fizzBuzzService::fizzbuzz);
        service.submit(fizzBuzzService::number);
        service.shutdown();
    }

}
