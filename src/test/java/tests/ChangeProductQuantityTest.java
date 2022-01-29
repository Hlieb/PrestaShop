package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeProductQuantityTest extends BaseTest {

    @Test
    public void ChangeProductQuantityByButtonTest() {
        addFadedShortsToCart.addShorts();
        cartPage.increaseProductQuantityByButton();
        Assert.assertEquals(cartPage.getProductQuantityFromMessage(), "2 products", "Error");
    }
}
