package ce.controller;

import ce.api.controller.ServerTimeApi;
import ce.api.dto.ServerTimeDto;
import ce.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerTimeController implements ServerTimeApi {
	@Autowired
	private Util util;

	@Override
	public ResponseEntity<ServerTimeDto> getServerTime() {
		ServerTimeDto response = util.getSystemTime();
		return ResponseEntity.ok(response);
	}
}
