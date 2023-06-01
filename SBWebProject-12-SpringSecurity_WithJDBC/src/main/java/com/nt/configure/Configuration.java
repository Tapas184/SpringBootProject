package com.nt.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//build Authentication Manager by taking authentication info provider(Inmemory DB)
		/*auth.inMemoryAuthentication().withUser("Tapas").password("{noop}bani").authorities("customer");
		auth.inMemoryAuthentication().withUser("Subha").password("{noop}subha").authorities("customer","manager");
		*/	
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?") //for Authentication
		.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USERS_ROLES WHERE UNAME=?"); // for authorization
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
