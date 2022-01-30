package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeProductQuantityTest extends BaseTest {

    @Description("This test checks if user could change quantity of products by pressing button at Cart menu")
    @Test(description = "User changes product quantity", groups = {"cart test"})
    public void ChangeProductQuantityByButtonTest() {
        addFadedShortsToCart.addShorts();
        cartPage.increaseProductQuantityByButton();
        Assert.assertEquals(cartPage.getProductQuantityFromMessage(), "2 product", "Error");
    }
}
