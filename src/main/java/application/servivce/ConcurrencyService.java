package application.servivce;

import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ConcurrencyService {

    // Demonstrate simple multithreading using Runnable
    public void demonstrateMultithreading() {
        Runnable task = () -> {
            // Simulate a task
            System.out.println("Running task in thread: " + Thread.currentThread().getName());
        };

        // Create and start threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }

    // Use an ExecutorService to manage concurrency
    public void demonstrateConcurrency() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable task = () -> {
            // Simulate a concurrent task
            System.out.println("Concurrent task executed by: " + Thread.currentThread().getName());
        };

        // Submit tasks to the executor
        executor.submit(task);
        executor.submit(task);

        // Shutdown the executor
        executor.shutdown();
    }
}
