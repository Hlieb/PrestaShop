package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteItemFromCartTest extends BaseTest {

    @Description("This test checks if user could delete item from the cart")
    @Test(description = "User deletes product from the cart", groups = {"cart test"})
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
