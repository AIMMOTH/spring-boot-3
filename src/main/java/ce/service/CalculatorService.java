package ce.service;

import ce.api.dto.ParameterMultiplicationDto;
import ce.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {

    @Value("${ce.multiplier}")
    private Integer multiplier;

    @Autowired
    private Util util;

    public ParameterMultiplicationDto multiply(Integer value) {
        var result = util.multiply(multiplier, value);
        return new ParameterMultiplicationDto().value(result);
    }
}
