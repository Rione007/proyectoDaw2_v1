package cibertec.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestVentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestVentaApplication.class, args);
		System.out.println("Corriendo REST-Venta.....");
	}

}
