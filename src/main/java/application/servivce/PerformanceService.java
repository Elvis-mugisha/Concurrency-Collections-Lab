package application.servivce;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PerformanceService {

    // Compare performance of non-concurrent List and CopyOnWriteArrayList
    public void comparePerformance() {
        List<Integer> nonConcurrentList = new ArrayList<>();
        List<Integer> concurrentList = new CopyOnWriteArrayList<>();

        // Measure time for non-concurrent list
        long startNonConcurrent = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            nonConcurrentList.add(i);
        }
        long endNonConcurrent = System.nanoTime();

        // Measure time for concurrent list
        long startConcurrent = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            concurrentList.add(i);
        }
        long endConcurrent = System.nanoTime();

        System.out.println("Non-Concurrent List Time: " + (endNonConcurrent - startNonConcurrent));
        System.out.println("Concurrent List Time: " + (endConcurrent - startConcurrent));
    }
}