package og.shop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
//@EnableWebSecurity
public class AppConfig {
    private final Environment environment;

    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource getDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setName(environment.getProperty("db.name"))
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf
//                        // Ignorisanje matchere za csrf za pristup h2 konzoli
//                        .ignoringRequestMatchers("/console/**")
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                )
//                .authorizeHttpRequests(authorize -> authorize
//                        //Za pristup konozli samo administranorti
//                        .requestMatchers("/console/**", "/inventory/**", "/order/**").hasRole("ADMIN")
//                        //Ostatak korisnici
//                        .requestMatchers("/item/**", "/user/**", "/receipt/**").hasRole("USER")
//                        //Svi pristup error stranici
//                        .requestMatchers("/error/**").permitAll()
//                        //Zahteva autentifikaciju za sve pozive
//                        .anyRequest().authenticated()
//                )
//                .headers(headers -> headers
//                        // Podesavanja za header-e neophodni za rad /console in memory baze
//                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)
//                )
//                //Koriscenje osnovnih http pravilia pristupa
//                .httpBasic(withDefaults())
//                //Dodavanje logovanje formom kao i logout
//                .formLogin(withDefaults());
//
//        return http.build();
//    }

//    @Bean
//    public UserDetailsManager users(DataSource dataSource) {
//        //dodavanje user naloga
//        //withDefaultPasswordEncoder automatski koristi hesiranje pasworda po defaultu
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//
//        //dodavanje admin naloga
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//
//        //koriscenje postojece baze za upis i citanje korisnika
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//
//        users.createUser(user);
//        users.createUser(admin);
//
//        return users;
//    }
}
