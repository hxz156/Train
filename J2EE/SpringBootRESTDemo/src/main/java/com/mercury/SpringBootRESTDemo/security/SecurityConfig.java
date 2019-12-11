package com.mercury.SpringBootRESTDemo.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mercury.SpringBootRESTDemo.security.handler.AccessDeniedHandlerImpl;
import com.mercury.SpringBootRESTDemo.security.handler.AuthenticationEntryPointImpl;
import com.mercury.SpringBootRESTDemo.security.handler.AuthenticationFailureHandlerImpl;
import com.mercury.SpringBootRESTDemo.security.handler.AuthenticationSuccessHandlerImpl;
import com.mercury.SpringBootRESTDemo.security.handler.LogoutSuccessHandlerImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true) // 可以在 Controller method 加限制
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;
	@Autowired
	AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
	
	@Autowired
	// use interface here, because only one class under this interface.
	UserDetailsService	userDetailsService;
	
	// 把要 Autowired 的东西，作为参数。 Autowired 一些东西，立刻执行代码：
	@Autowired
	public void setup(AuthenticationManagerBuilder builder) throws Exception {
		// provide custom UserdetailService to Spring Security
		// Spring Security will take it and use it to load user by username.
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Autowired
	AuthenticationEntryPointImpl authenticationEntryPointImpl;
	@Autowired
	AccessDeniedHandlerImpl accessDeniedHandlerImpl;
	@Autowired
	LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// turn off CSRF(cross-site request forgery) protection
		http.csrf().disable();
		// login
		http.formLogin()
			.loginProcessingUrl("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(authenticationSuccessHandlerImpl)
			.failureHandler(authenticationFailureHandlerImpl);
		// declarative way for authorization
//		http.authorizeRequests()
//		.antMatchers(HttpMethod.GET, "/products").permitAll()
//		.antMatchers(HttpMethod.GET, "/samples").authenticated()
//		.antMatchers(HttpMethod.GET, "/orders").hasAnyAuthority("ROLE_ADMIN");
		
		// exception handling
		// e.g. user wants to access resource which he is not permitted
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandlerImpl);
		// e.g. unauthenticated(not logged in) users want to access protected resource.
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPointImpl);
		// remember me
		http.rememberMe();
		// logout: logout 之后 session 就没有了。
		http.logout()
		.logoutUrl("/logout")
		.logoutSuccessHandler(logoutSuccessHandlerImpl);
		
	}
	
	// IoC: 创建一个 PasswordEncoder 的对象。
	@Bean
	public PasswordEncoder passwordEncoder() {
		// 11 -> Strength
		return new BCryptPasswordEncoder(11);
	}
	
	/*
     * cors support
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
//      configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.addAllowedOrigin("*"); // You should only set trusted site here. e.g. http://localhost:4200 means only this site can access.
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}







