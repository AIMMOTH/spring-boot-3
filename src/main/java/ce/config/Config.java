package ce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ce.util.Util;

@Configuration
public class Config {

	@Bean
	public Util getUtil() {
		return new Util();
	}
}
