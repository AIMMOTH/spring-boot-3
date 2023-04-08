package ce.controller;

import ce.api.controller.ServerTimeApi;
import ce.api.dto.ServerTimeDto;
import ce.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ServerTimeController implements ServerTimeApi {
	private Util util;

	@Override
	public ResponseEntity<ServerTimeDto> getServerTime() {
		ServerTimeDto response = util.getSystemTime();
		return ResponseEntity.ok(response);
	}
}
