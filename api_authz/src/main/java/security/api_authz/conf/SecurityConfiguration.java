package security.api_authz.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import security.api_authz.service.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration{

	@Autowired
	private UserService userService;
	
	@Bean                                                     
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {

		http
		.csrf().disable()
		.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/login").permitAll()
				.requestMatchers("/swagger-ui/*").permitAll()
				.requestMatchers("/v3/api-docs").permitAll()
				.requestMatchers("/v3/api-docs/*").permitAll()
				.requestMatchers("/v3/*").permitAll()
				.anyRequest().authenticated()
		);
		http.addFilterBefore(new JWTAuthenticationFilter(userService), BasicAuthenticationFilter.class);
		http.addFilterAfter(new JWTAuthorizationFilter(userService),BasicAuthenticationFilter.class);
		return http.build();

	}
}
