package asw;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class InciManagerWebSecurity extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().authorizeRequests()
					.antMatchers("/css/**", "/img/**", "/script/**", "/", "/signup", "/login/**").permitAll()
					.antMatchers("/incidences/**").authenticated()
					.antMatchers("/home").authenticated()
						.and()
					.formLogin().loginPage("/login").permitAll()
					.defaultSuccessUrl("/home")
						.and()
					.logout().permitAll();
		}


}
