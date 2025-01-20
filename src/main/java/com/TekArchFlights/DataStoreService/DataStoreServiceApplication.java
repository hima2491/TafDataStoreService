package com.TekArchFlights.DataStoreService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.TekArchFlights.DataStoreService")
public class DataStoreServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataStoreServiceApplication.class, args);
	}
}
