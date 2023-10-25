package com.emr.basketservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BasketServiceApplication implements CommandLineRunner {

	private final BasketService basketService;

	public static void main(String[] args) {
		SpringApplication.run(BasketServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			Thread.sleep(100);
			basketService.addToBasket();
		}
	}
}
