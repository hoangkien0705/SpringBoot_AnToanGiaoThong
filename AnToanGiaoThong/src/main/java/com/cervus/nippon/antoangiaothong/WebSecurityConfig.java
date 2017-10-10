package com.cervus.nippon.antoangiaothong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cervus.nippon.antoangiaothong.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/register").permitAll()
            	.antMatchers("/").permitAll()
            	.antMatchers("/admin").hasRole("ADMIN")
            	.and()
            .formLogin()
            	.loginPage("/login").permitAll()
            	.usernameParameter("username")
            	.passwordParameter("password")
            	.defaultSuccessUrl("/login_success", true)
            	.failureUrl("/login_error")
            	.and()
        	.logout()
        		.logoutSuccessUrl("/logout_success")
        		.permitAll()
        		.and()
            .exceptionHandling()
            .accessDeniedPage("/403")
            .configure(http);
    }
    
}
