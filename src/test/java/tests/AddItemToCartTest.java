package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCartTest extends BaseTest{

    @Test
    public void AddItemsToCartTest(){
        addFadedShortsToCart.addShorts();
        Assert.assertEquals(cartPage.getProductQuantityFromCounter(),"1","Error");
    }

    @Test
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
