package ce.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@Log
public class SecurityConfig {

  @Value("${auth0.audience}")
  private String audience;

  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String issuer;

//  @Value("${cors}")
//  private String cors;

//  @Value("${csp}")
//  private String csp;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .requestMatchers("/api/v1/public/**", "/", "/index.html", "/favicon.ico", "/auth_config.json", "/web-socket/").permitAll()
        .requestMatchers("/api/v1/private/**").authenticated()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().oauth2ResourceServer().jwt()
        ;
    return http.build();
  }

//  @Override
//  public void addCorsMappings(CorsRegistry registry) {
//    registry.addMapping("/**").allowedMethods("*");
//  }

  @Bean
  JwtDecoder jwtDecoder() {
      log.info("audience:" + audience + ", issuer:" + issuer);
      NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);

      OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
      OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
      OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

      jwtDecoder.setJwtValidator(withAudience);

      return jwtDecoder;
  }

//  private CorsConfigurationSource corsConfigurationSource() {
//    final CorsConfiguration configuration = new CorsConfiguration();
//    configuration.setAllowedMethods(Arrays.asList(
//      HttpMethod.GET.name(),
//      HttpMethod.PUT.name(),
//      HttpMethod.POST.name(),
//      HttpMethod.DELETE.name()
//    ));
//
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
//    return source;
//  }

//  @Bean
//  SecurityWebFilterChain springSecurityFilterChain(final ServerHttpSecurity http) {
//    http.headers().contentSecurityPolicy("default-src 'self' " + csp)
//      .reportOnly(true)
//      ;
//    return http.build();
//  }
}
