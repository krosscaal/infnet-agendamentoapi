package br.edu.infnet.krossbyagendamentoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KrossbyagendamentoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrossbyagendamentoapiApplication.class, args);
	}

}
