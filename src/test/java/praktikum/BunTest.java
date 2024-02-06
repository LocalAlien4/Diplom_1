package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;
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
    @Test
    public void getNameTest() {
        Bun bun= new Bun(bunName,bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun= new Bun(bunName,bunPrice);
        assertEquals(bunPrice, bun.getPrice(),0.5);
    }
}