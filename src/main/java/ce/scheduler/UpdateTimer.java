package ce.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UpdateTimer {

	private Logger logger = Logger.getLogger(UpdateTimer.class.getName());

	private static int tick = 0;

	@Scheduled(fixedDelay = 1000l)
	public void update1000ms() {
		tick++;
		logger.info("Tick:" + tick);
	}
}
