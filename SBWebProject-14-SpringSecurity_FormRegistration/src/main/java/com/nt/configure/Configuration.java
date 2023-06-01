package com.nt.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.nt.model.CustomerModel;
import com.nt.service.ICustomerService;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {
@Autowired
	private ICustomerService service;
@Autowired
private BCryptPasswordEncoder encode;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//build Authentication Manager by taking authentication info provider(Inmemory DB)
		/*auth.inMemoryAuthentication().withUser("Tapas").password("{noop}bani").authorities("customer");
		auth.inMemoryAuthentication().withUser("Subha").password("{noop}subha").authorities("customer","manager");
		*/	
		/*auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?") //for Authentication
		.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USERS_ROLES WHERE UNAME=?"); // for authorization
		*/	
		auth.userDetailsService(service).passwordEncoder(encode);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.antMatchers("/").permitAll()
        		.antMatchers("/cust_login","/home_auth").permitAll()
        		.antMatchers("/reg_cust").hasAuthority("manager")
                .antMatchers("/check_loan").hasAuthority("manager")
                .antMatchers("/check_balance").hasAnyAuthority("customer", "manager")
                .anyRequest().authenticated())
               .formLogin(s->s
            		   .defaultSuccessUrl("/home_auth",true) //for default home page after successful login
            		   .loginPage("/cust_login")  //this for custom login Page
            		   .loginProcessingUrl("/login") //this for post-mode login page where processing the login
            		   .failureUrl("/cust_login?error")) //this is the error where if login failure
               .rememberMe(withDefaults())
               .logout(l->l.
            		   logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//this for logout url
            		   .logoutSuccessUrl("/cust_login?logout"))//after successful logout request goes to login page
               .exceptionHandling(handling -> handling //if exception rise while any authorization failed
            		   .accessDeniedPage("/acc_denined"))//authorization failes custom error page
        .sessionManagement(management -> management
        		.maximumSessions(2)
        		.maxSessionsPreventsLogin(true)
        		.expiredUrl("/session_timeout"));
		    
	}
}
