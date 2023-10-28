package com.emr.stockservice;

import com.emr.stockservice.data.Stock;
import com.emr.stockservice.data.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
/*@RequiredArgsConstructor*/
public class StockServiceApplication {

/*
	private final StockRepository stockRepository;
*/

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		Stock stock = new Stock();
		stock.setProductId(UUID.fromString("5eeaae8e-e873-44a9-8615-2ca6b5a46dd2"));
		stock.setAmount(55);

		stockRepository.save(stock);
	}*/
}