package fr.but3.ctp;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    public SecurityFilterChain mesautorisations(HttpSecurity http, HandlerMappingIntrospector introspector)
            throws Exception {
        MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);
        return http.authorizeHttpRequests((authorize) -> {
                            try {
                                authorize
                                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                        .requestMatchers(mvc.pattern("/voter")).hasRole("USER")
                                        .requestMatchers(mvc.pattern(("/activer")), mvc.pattern("/voir")).hasRole("ADMIN")
                                                        .anyRequest().authenticated()
                                                        .and()
                                                        .csrf((csrf) -> csrf.disable());
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        )
                .formLogin(Customizer.withDefaults())
                .rememberMe( configurer ->
                        configurer.rememberMeParameter("remember")
                                .useSecureCookie(true)
                )
                .build();
    }

    @Bean
    public UserDetailsService mesutilisateurs() {
        UserDetails u0 = User.withUsername("admin")
                .password(encoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails u1 = User.withUsername("user1")
                .password(encoder().encode("user1"))
                .roles("USER")
                .build();
        UserDetails u2 = User.withUsername("user2")
                .password(encoder().encode("user2"))
                .roles("USER")
                .build();
        UserDetails u3 = User.withUsername("user3")
                .password(encoder().encode("user3"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(u0,u1,u2,u3);
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}