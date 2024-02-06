package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;
    Bun bun;
    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }
    @Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"burnt bun", 0},
        };
    }
    @Before
    public void setUp() {
        bun = new Bun(bunName,bunPrice);
    }
    @Test
    public void checkIsCorrectGetNameBunTest() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void checkIsCorrectGetPriceBunTest() {
        assertEquals(bunPrice, bun.getPrice(),0.5);
    }
}