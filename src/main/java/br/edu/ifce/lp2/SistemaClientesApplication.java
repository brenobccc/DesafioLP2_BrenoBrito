package br.edu.ifce.lp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaClientesApplication.class, args);
		System.out.println("SERVER RUNNING");
	}

}
