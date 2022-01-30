package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageChangeTest extends BaseTest {

    @Description("This test checks if user could change current language to Ukrainian language")
    @Test(description = "User changes current language to Ukrainian", groups = {"localization"})
    public void changeLanguageToUkrainianTest() {
        mainPage.openPage();
        headerPage.languageChangeToUkr();
        Assert.assertEquals(driver.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/uk/", "Error");
        Assert.assertEquals(headerPage.getCurrentLanguage(), "Українська", "Error");
    }

    @Description("This test checks if user could change current language to English language")
    @Test(description = "User changes current language to English", groups = {"localization"})
    public void changeLanguageToEnglishTest() {
        mainPage.openPage();
        headerPage.languageChangeToEng();
        Assert.assertEquals(driver.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/en/", "Error");
        Assert.assertEquals(headerPage.getCurrentLanguage(), "English", "Error");
    }
}
