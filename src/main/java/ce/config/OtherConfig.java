package ce.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@EnableConfigurationProperties
@PropertySource("classpath:other.properties")
public class OtherConfig {

    /*
     * If you have a property called "secret1" it will be mapped to this field.
     * If not, it will look for "secret3"
     * and otherwise give default value "top-secret"
     */
    @Value("${secret3:top-secret}")
    private String secret1;

    @Value("${secret4:super}")
    private String secret2;
}
