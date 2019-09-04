package com.example.ALERTSYSTEM;

import com.example.ALERTSYSTEM.services.RequestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAsync
@EnableScheduling
//onları çağırıyoruz.
public class AlertsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertsystemApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();

	}
}
