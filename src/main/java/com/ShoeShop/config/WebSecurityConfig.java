package com.ShoeShop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.ShoeShop.Service.AdminService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
//	@Autowired
//    private AdminService adminService;
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable();
		 http.headers().frameOptions().disable();
		 
		 //The pages does not require login
	     http.authorizeRequests().antMatchers("/", "/login", "/logout","/h2").permitAll();
	     // AccessDeniedException will be thrown.
	     http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
	     // For ADMIN only.
	     http.authorizeRequests().antMatchers("/admin").authenticated().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
	     // Config for Login Form
	     http.authorizeRequests().and().formLogin()//
	                // Submit URL of login page.
	                .loginProcessingUrl("/j_spring_security_check") // Submit 
	                .defaultSuccessUrl("/admin")//
	                .failureUrl("/login?error=true")//
	                .usernameParameter("username")//
	                .passwordParameter("password")
	                .permitAll();
	 
	    
	     
	 }
	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new AdminService();
	    }
	     
	 @Override
	 public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 //System.out.println(adminService.getpwd());
		  DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        auth.authenticationProvider(authProvider);
	        //auth.inMemoryAuthentication().withUser( "admin@shoeshop").password("{noop}"+adminService.getpwd()).roles("ADMIN");
	    }


}
