package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void checkSauceNotNullTest() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }
    @Test
    public void checkFillingNotNullTest() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}