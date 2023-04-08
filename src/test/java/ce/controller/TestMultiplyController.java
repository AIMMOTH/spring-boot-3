package ce.controller;

import ce.api.dto.ParameterMultiplicationDto;
import ce.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class TestMultiplyController {

    @Mock
    private CalculatorService calculator;
    @InjectMocks
    private MultiplyController underTest;

    @DisplayName("Should call service")
    @Test
    public void getParameterMultiplication() {
        // Given
        var parameter = 1;
        var value = 2;
        var response = Mockito.mock(ParameterMultiplicationDto.class);

        Mockito.when(calculator.multiply(Mockito.eq(parameter))).thenReturn(response);
        Mockito.when(response.getValue()).thenReturn(value);

        // When
        var actual = underTest.getParameterMultiplication(parameter);

        // Then
        Assertions.assertEquals(value, actual.getBody().getValue());
    }
}
