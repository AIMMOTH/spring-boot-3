package ce.controller;

import ce.api.controller.MultiplyApi;
import ce.api.dto.ParameterMultiplicationDto;
import ce.service.CalculatorService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Log
@RestController
public class MultiplyController implements MultiplyApi {

	private CalculatorService calculator;

	@Override
	public ResponseEntity<ParameterMultiplicationDto> getParameterMultiplication(Integer value) {
		log.info("Value:" + value);
		ParameterMultiplicationDto response = calculator.multiply(value);
		return ResponseEntity.ok(response);
	}
}
