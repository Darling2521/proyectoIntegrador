package security.api_authz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("security.api_authz.repository")
public class ApiAuthzApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAuthzApplication.class, args);
	}

}
