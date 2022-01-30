package tests;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyChangeTest extends BaseTest {

    @Description("This test checks if user could change currency and choose USD")
    @Test(description = "User changes current currency to USD", groups = {"localization"})
    public void changeCurrencyToUsd() {
        mainPage.openPage();
        headerPage.languageChangeToEng();
        headerPage.currencyChangeToUsd();
        Assert.assertEquals(headerPage.getCurrentCurrency(), "Currency : USD", "Error");
    }

    @Description("This test checks if user could change currency and choose EUR")
    @Test(description = "User changes current currency to EUR", groups = {"localization"})
    public void changeCurrencyToEur() {
        mainPage.openPage();
        headerPage.languageChangeToEng();
        headerPage.currencyChangeToEur();
        Assert.assertEquals(headerPage.getCurrentCurrency(), "Currency : EUR", "Error");
    }
}
