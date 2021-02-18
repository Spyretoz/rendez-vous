package rendez.vous.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import rendez.vous.jwt.JwtAuthenticationEntryPoint;
import rendez.vous.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter 
{
	// bcrypt-generator.com to encrypt passwords

		@Autowired
		private DataSource dataSource;
		
		//@Autowired
		private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

		//@Autowired
		private UserDetailsService jwtUserDetailsService;

		//@Autowired
		private JwtAuthenticationFilter jwtRequestFilter;

		
		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception 
		{
			return super.authenticationManagerBean();
		}
//		
//		//@Autowired
//		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
//		{
//			// configure AuthenticationManager so that it knows from where to load
//			// user for matching credentials
//			// Use BCryptPasswordEncoder
//			auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
//		}
//		
//		@Override
//	    protected void configure(HttpSecurity http) throws Exception 
//		{
//			http.csrf().disable()
//					// dont authenticate this particular request
//					.authorizeRequests().antMatchers("/authenticate", "/register").permitAll().
//					// all other requests need to be authenticated
//							anyRequest().authenticated().and().
//					// make sure we use stateless session; session won't be used to
//					// store user's state.
//							exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//			// Add a filter to validate the tokens with every request
//			http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//	    }
		
		
		

		
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception 
		{

			auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
					.usersByUsernameQuery("select username, user_password, enabled from user where username=?")
					.authoritiesByUsernameQuery("select user_name, accountType from userRoles where user_name=?");

		}

		@Override
		protected void configure(HttpSecurity http) throws Exception 
		{	
			http.csrf().disable()
					.authorizeRequests() // authorize
					.antMatchers("/").permitAll() // allow "/" to be seen without authentication
					.antMatchers("/api/**").hasRole("ADMIN")
					.antMatchers("/user/**").hasRole("ADMIN") // allow "/user" and subdirectories to be seen only from admin
					.antMatchers("/carrier/**").hasRole("MANAGER") // allow "/carrier" and subdirectories to be seen only from manager
					.antMatchers("/form/**").hasAnyRole("MANAGER", "CHIEF") // allow "/form" and subdirectories to be seen only from chief
					.anyRequest().authenticated() // all requests are authenticated
					.and().formLogin().permitAll() // allow "/login"
					.defaultSuccessUrl("/", true) // set default page for success login
					.and().logout().permitAll(); // allow "logout"
		}
		
		@Bean
		public PasswordEncoder passwordEncoder() 
		{
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder;
		}
}