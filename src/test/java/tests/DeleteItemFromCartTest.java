package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteItemFromCartTest extends BaseTest {

    @Test
    public void deleteItemFromCartTest(){
        mainPage.openPage()
                .clickAtWomanCategoryButton()
                .chooseFadedShort()
                .addItemToCart()
                .clickCheckoutButton()
                .deleteItem();
        Assert.assertEquals(cartPage.getProductQuantityFromMessage(),"0 product","Error");
    }
}
