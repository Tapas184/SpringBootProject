package com.nt.configure;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//build Authentication Manager by taking authentication info provider(Inmemory DB)
		auth.inMemoryAuthentication().withUser("Tapas").password("{noop}bani").authorities("customer");
		auth.inMemoryAuthentication().withUser("Subha").password("{noop}subha").authorities("customer","manager");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.antMatchers("/").permitAll()
                .antMatchers("/check_loan").hasAuthority("manager")
                .antMatchers("/check_balance").hasAnyAuthority("customer", "manager")
                .anyRequest().authenticated()).formLogin(withDefaults()).rememberMe(withDefaults()).logout(withDefaults()).exceptionHandling(handling -> handling.accessDeniedPage("/acc_denined"))
        .sessionManagement(management -> management.maximumSessions(2).maxSessionsPreventsLogin(true).expiredUrl("/session_timeout"));
		    
	}
}
