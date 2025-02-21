package is.webworks.springbootrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return  provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF
        http.csrf(customizer -> customizer.disable());
        // All requests should be authenticated
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        //http.formLogin(Customizer.withDefaults());
        // Login page that works with http headers
        http.httpBasic(Customizer.withDefaults());
        // Session should be stateless
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    /*@Bean
    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder().username("arnar1").password("n@223").roles("USER").build();
//        UserDetails admin = User.withDefaultPasswordEncoder().username("admin1").password("a@223").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user, admin);
    }*/
}
