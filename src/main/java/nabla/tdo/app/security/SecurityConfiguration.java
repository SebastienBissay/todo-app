package nabla.tdo.app.security;

import lombok.NoArgsConstructor;
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

    // Méthode pour configurer le mode d'authentification
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication() // Authentification en mémoire, donc pas de vérif en BDD
                .passwordEncoder(NoOpPasswordEncoder.getInstance()) // on ne veut pas que le mdp soit crypté
                .withUser("user").password("user")
                .roles("USER");
    }
//     Permet de configurer la protection url

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/login") // Pour les requêtes qui matchent cette uri
                .permitAll() // Autoriser toutes les requêtes => donc pas besoin d'être connecté
                //                .antMatchers("/admin") // Configuration d'une aute page
                //                .hasRole("ADMIN") // Doit aoir le rôle ADMIN
                .anyRequest().hasRole("USER") // Pour toutes les autres requêtes, on demande une authentification avec le rôle USER
                .and()
                .formLogin(); // On active le formulaire de login

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
