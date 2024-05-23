package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
@EnableKafka
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public Consumer<String> sink() {
		return System.out::println;
	}

	@Bean
	public Consumer<String> dump() {
		return System.out::println;
	}

	@Bean
	public Function<String, String> uppercase() {
		return value -> {
			System.out.println("Received: " + value);
			return value.toUpperCase();
		};
	}

}
