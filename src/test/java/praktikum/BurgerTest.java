package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientFilling;
    @Mock
    private Ingredient ingredientSauce;
    @Before
    public void setUp() {
        burger = new Burger();
    }
    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientFilling);
        assertTrue(burger.ingredients.contains(ingredientFilling));
    }
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        burger.moveIngredient(0,1);
        assertEquals(ingredientSauce, burger.ingredients.get(0));
        assertEquals(ingredientFilling, burger.ingredients.get(1));
    }
    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(200f);
        assertEquals(burger.getPrice(),400f,0);
    }
    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.getPrice();
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn("chili sauce");
        Mockito.when(burger.getPrice()).thenReturn(700f);
        String actual = burger.getReceipt();
        String expected = String.format("(==== white bun ====)%n" +
                "= sauce chili sauce =%n" +
                "(==== white bun ====)%n" +
                "%n" +
                "Price: 700,000000%n");
        assertEquals(expected,actual);
    }
}