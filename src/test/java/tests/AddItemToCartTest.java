package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCartTest extends BaseTest{

    @Description("This test checks if user could add product to cart")
    @Test(description = "User adds product to cart", groups = {"cart test"})
    public void AddItemsToCartTest(){
        addFadedShortsToCart.addShorts();
        Assert.assertEquals(cartPage.getProductQuantityFromCounter(),"1","Error");
    }

    @Description("This test checks if user could add a few product to cart ")
    @Test(description = "User adds a few products to cart", groups = {"cart test"})
    public void AddFewItemsToCartTest(){
        addFadedShortsToCart.addShorts();
        mainPage.searchByKeyWord("dress")
                .clickAtSearchButton()
                .choosePrintedSummerDress()
                .addItemToCart()
                .clickCheckoutButton();
        Assert.assertEquals(cartPage.getProductQuantityFromCounter(),"2","Error");
    }
}
