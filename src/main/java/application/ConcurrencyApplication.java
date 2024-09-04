package application;

import application.servivce.ConcurrencyService;
import application.servivce.ConcurrentCollectionsService;
import application.servivce.PerformanceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ConcurrencyApplication {

	private final ConcurrencyService concurrencyService;
	private final ConcurrentCollectionsService collectionsService;
	private final PerformanceService performanceService;

	public ConcurrencyApplication(ConcurrencyService concurrencyService,
								  ConcurrentCollectionsService collectionsService,
								  PerformanceService performanceService) {
		this.concurrencyService = concurrencyService;
		this.collectionsService = collectionsService;
		this.performanceService = performanceService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			// Demonstrate concurrency and multithreading
			System.out.println("Running Concurrency and Multithreading Demonstrations:");
			concurrencyService.demonstrateMultithreading();
			concurrencyService.demonstrateConcurrency();

			// Use concurrent collections
			System.out.println("\nUsing Concurrent Collections:");
			collectionsService.useConcurrentMap();

			// Compare performance
			System.out.println("\nComparing Performance of Collections:");
			performanceService.comparePerformance();
		};
	}
}
