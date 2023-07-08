package com.security.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
	
	@Bean
	UserDetailsService createuserDetailsService() {
		/*UserDetails user = User.withUsername("Tapas")
				.password(encode.encode("tapas"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);*/
		return new UserinfoUserDetailsService();
	}
	
	@Bean
	SecurityFilterChain filterChan(HttpSecurity http) throws Exception {
	return	http.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/security/adduser","/security/welcome")
			.permitAll()
			.and()
		    .authorizeHttpRequests()
		    .requestMatchers("/security/product/**") 
		    .authenticated()
		    .and().formLogin()
		    .and()
		    .logout()
		    .logoutUrl("/logout")
		    .logoutSuccessUrl("/login?logout")
		    .invalidateHttpSession(true)
		    .deleteCookies("JSESSIONID")
		    .permitAll()
		    .and()
		    .build();
	}

	@Bean
	PasswordEncoder encodePassword() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	 AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
		daoAuth.setUserDetailsService(createuserDetailsService());
		daoAuth.setPasswordEncoder(encodePassword());
		return daoAuth;
		
	}
}
