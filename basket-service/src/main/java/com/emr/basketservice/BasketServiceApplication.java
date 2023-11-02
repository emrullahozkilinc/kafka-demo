package com.emr.basketservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			Thread.sleep(1000);
			basketService.addToBasket();
		}
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
