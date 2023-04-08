package ce.controller;

import ce.api.controller.MultiplyApi;
import ce.api.dto.ParameterMultiplicationDto;
import ce.service.CalculatorService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplyController implements MultiplyApi {

	private Logger log = Logger.getLogger(MultiplyController.class);

	@Autowired
	private CalculatorService calculator;

	@Override
	public ResponseEntity<ParameterMultiplicationDto> getParameterMultiplication(Integer value) {
		log.info("Value:" + value);
		ParameterMultiplicationDto response = calculator.multiply(value);
		return ResponseEntity.ok(response);
	}
}
