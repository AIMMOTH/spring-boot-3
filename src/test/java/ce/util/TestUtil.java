package ce.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

public class TestUtil {

    private Util underTest = new Util();

    @DisplayName("Should multiply values")
    @Test
    public void multiply() {
        // Given
        var i1 = 3;
        var i2 = 5;
        var expected = i1 * i2;

        // When
        var actual = underTest.multiply(i1, i2);

        // Then
        Assertions.assertEquals(expected, actual);
    }
}
