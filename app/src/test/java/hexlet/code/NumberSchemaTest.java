package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    private final Integer number10 = 10;
    private final Integer number8 = 8;
    private final Integer numberMinus10 = -10;
    private final Integer number6 = 6;
    private final Integer number4 = 4;
    private final Integer number11 = 11;

    @Test
    public void numberSchemaTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(number10));
        Assertions.assertFalse(schema.isValid("5"));

        Assertions.assertTrue(schema.positive().isValid(number10));
        Assertions.assertFalse(schema.isValid(numberMinus10));

        schema.range(number6, number10);

        Assertions.assertTrue(schema.positive().isValid(number6));
        Assertions.assertTrue(schema.isValid(number8));
        Assertions.assertTrue(schema.isValid(number10));
        Assertions.assertFalse(schema.isValid(number4));
        Assertions.assertFalse(schema.isValid(number11));
    }
}