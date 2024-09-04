package application.servivce;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ConcurrentCollectionsService {

    private ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

    // Method to use ConcurrentHashMap
    public void useConcurrentMap() {
        concurrentMap.put("key1", 1);
        concurrentMap.put("key2", 2);

        // Simulate concurrent access
        Runnable reader = () -> {
            Integer value = concurrentMap.get("key1");
            System.out.println("Value for key1: " + value);
        };

        Runnable writer = () -> {
            concurrentMap.put("key1", 10);
            System.out.println("Updated value for key1");
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(reader);
        executor.submit(writer);
        executor.shutdown();
    }
}