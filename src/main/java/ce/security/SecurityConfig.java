package ce.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Log
public class SecurityConfig {

    /**
     * Also called API Identifier at Auth0
     */
  @Value("${auth0.audience}")
  private String audience;

  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String issuer;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests()
        .requestMatchers("/api/v1/public/**", "/", "/index.html", "/favicon.ico", "/auth_config.json", "/web-socket/"
        ).permitAll()
        .requestMatchers("/api/v1/private/**", "/server-time", "/multiply", "/immutable", "/row", "/user/**").authenticated()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().oauth2ResourceServer().jwt()
        ;
    return http.build();
  }

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
}
