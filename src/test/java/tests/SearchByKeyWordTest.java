package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByKeyWordTest extends BaseTest{

    @Test
    public void searchByKeyWordTest(){
        mainPage.openPage()
                .searchByKeyWord("dress")
                .clickAtSearchButton();
        Assert.assertEquals(itemPage.getKeyWord(),"\"DRESS\"","Error");
    }
}
