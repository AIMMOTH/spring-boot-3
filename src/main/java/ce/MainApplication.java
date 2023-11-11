package ce;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching // https://spring.io/guides/gs/caching/
@EnableScheduling
@Log
@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		log.info("Staring application ...");
		SpringApplication.run(MainApplication.class, args);
	}
}
