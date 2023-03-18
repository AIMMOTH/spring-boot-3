package ce.controllers;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ce.util.Util;

@RestController
public class Controller {
	
	@Autowired
	private Util util;

	@GetMapping("multiply")
	public int getMultiply() {
		return util.multiply(3, 5);
	}

	@GetMapping("time")
	public String getTime() {
		return ZonedDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"));
	}
}
