package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageChangeTest extends BaseTest {

    @Test
    public void changeLanguageToUkrainianTest() {
        mainPage.openPage();
        headerPage.languageChangeToUkr();
        Assert.assertEquals(driver.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/uk/", "Error");
        Assert.assertEquals(headerPage.getCurrentLanguage(), "Українська", "Error");
    }

    @Test
    public void changeLanguageToEnglishTest() {
        mainPage.openPage();
        headerPage.languageChangeToEng();
        Assert.assertEquals(driver.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/en/", "Error");
        Assert.assertEquals(headerPage.getCurrentLanguage(), "English", "Error");
    }
}
