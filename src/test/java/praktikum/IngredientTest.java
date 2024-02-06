package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    Ingredient ingredient;
    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }
    @Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300}
        };
    }
    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }
    @Test
    public void checkIsCorrectGetPriceIngredientTest() {
        assertEquals(ingredientPrice, ingredient.getPrice(), 0.5);
    }

    @Test
    public void checkIsCorrectGetNameIngredientTest() {
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(ingredientType, ingredient.getType());
    }
}