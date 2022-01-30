package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByKeyWordTest extends BaseTest{

    @Description("This test checks if user could search item on the website with keyword")
    @Test(description = "User searches product due to keyword", groups = {"search test"})
    public void searchByKeyWordTest(){
        mainPage.openPage()
                .searchByKeyWord("dress")
                .clickAtSearchButton();
        Assert.assertEquals(itemPage.getKeyWord(),"\"DRESS\"","Error");
    }
}
