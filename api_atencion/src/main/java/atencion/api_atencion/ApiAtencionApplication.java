package atencion.api_atencion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiAtencionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAtencionApplication.class, args);
	}

}
