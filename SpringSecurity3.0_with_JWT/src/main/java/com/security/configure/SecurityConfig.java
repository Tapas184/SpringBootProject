package com.security.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.filter.JwtFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
	
	
	@Autowired
	private JwtFilter jwtFilter;
	
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
			.requestMatchers("/security/adduser","/security/welcome","/security/authenticate")
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
		    .sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		    .and()
		    .authenticationProvider(authenticationProvider())
		    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
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
	
	@Bean
	 AuthenticationManager createAuthenticationManager(AuthenticationConfiguration config) throws Exception {
		
		return config.getAuthenticationManager();
	}
}
