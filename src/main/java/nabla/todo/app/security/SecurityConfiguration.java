package nabla.todo.app.security;

import lombok.NoArgsConstructor;
import nabla.todo.app.controller.LogoutController;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 *
 * @author Pad
 */
@NoArgsConstructor
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("user")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/login")
                .permitAll()
                .anyRequest().hasRole("USER")
                .and()
                .formLogin()
                .and()
                .logout(logout -> logout
                    .logoutUrl("/logout")
                    .addLogoutHandler(new LogoutController())
                    .logoutSuccessUrl("/login")
                );

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
