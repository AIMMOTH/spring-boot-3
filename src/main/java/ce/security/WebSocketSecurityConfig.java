package ce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;
import org.springframework.security.messaging.access.intercept.MessageMatcherDelegatingAuthorizationManager;

@Configuration
@EnableWebSocketSecurity
public class WebSocketSecurityConfig {

    @Bean
    AuthorizationManager<Message<?>> messageAuthorizationManager(MessageMatcherDelegatingAuthorizationManager.Builder messages) {
        return messages
            .anyMessage().permitAll()
            .nullDestMatcher().permitAll()
            .simpDestMatchers("**").permitAll()
            .simpMessageDestMatchers("**").permitAll()
            .simpSubscribeDestMatchers("**").permitAll()
            .build()
            ;
    }
}
