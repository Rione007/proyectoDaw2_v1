package cibertec.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class RestReporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestReporteApplication.class, args);
		System.out.println("Se levanto Rest-Reporte");
	}

}
