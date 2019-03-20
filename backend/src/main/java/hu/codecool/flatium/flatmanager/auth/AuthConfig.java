package hu.codecool.flatium.flatmanager.auth;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
@PropertySource(value = "auth0.properties")
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;

    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8888"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()

                .antMatchers(HttpMethod.POST, "/create-flat").hasAuthority("admin")
                .antMatchers(HttpMethod.DELETE, "/delete-flat").hasAuthority("admin")
                .antMatchers(HttpMethod.POST, "/add-to-flat").hasAuthority("admin")
                .antMatchers(HttpMethod.POST, "/create-building").hasAuthority("admin")
                .antMatchers(HttpMethod.DELETE, "/delete-building").hasAuthority("admin")
                .antMatchers(HttpMethod.POST, "/add-flat").hasAuthority("admin")
                .antMatchers(HttpMethod.GET, "/get-comments").hasAuthority("admin")

                .antMatchers(HttpMethod.GET, "/get-myflat/{user_id}").hasAuthority("resident")
                .antMatchers(HttpMethod.POST, "/update-flat").hasAuthority("resident")
                .antMatchers(HttpMethod.POST, "/update-flatuser").hasAuthority("resident")
                .antMatchers(HttpMethod.POST, "/add-comment").hasAuthority("resident")
                .antMatchers(HttpMethod.POST, "/update-comment").hasAuthority("resident")
                .antMatchers(HttpMethod.DELETE, "/delete-comment").hasAuthority("resident")
                .antMatchers(HttpMethod.GET, "/get-comments/{user-id}").hasAuthority("resident")
                .antMatchers(HttpMethod.POST, "/create-flatuser").hasAuthority("resident")
                .antMatchers(HttpMethod.DELETE, "/delete-flatuser").hasAuthority("resident")
                .antMatchers(HttpMethod.POST, "/update-flatuser").hasAuthority("resident")

                .antMatchers(HttpMethod.GET, "/get-flats").hasAuthority("landlord")
                .antMatchers(HttpMethod.GET, "/get-buildings").hasAuthority("landlord")
                .antMatchers(HttpMethod.GET, "/get-building").hasAuthority("landlord")
                .antMatchers(HttpMethod.GET, "/get-flatusers").hasAuthority("landlord")
                .antMatchers(HttpMethod.POST, "/update-building").hasAuthority("landlord")
                .antMatchers(HttpMethod.DELETE, "/delete-comment").hasAuthority("landlord");

    }
}
