package cibertec.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class SaludoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaludoServiceApplication.class, args);
		
		System.out.println("proyecto inicializado");
		System.out.println("http://localhost:9001/swagger-ui.html");
	}

}
