package ce.util;

import ce.api.dto.ServerTimeDto;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Util {

	public int multiply(int i1, int i2) {
		return i1 * i2;
	}

    public ServerTimeDto getSystemTime() {
		return new ServerTimeDto().value(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm")));
    }
}
