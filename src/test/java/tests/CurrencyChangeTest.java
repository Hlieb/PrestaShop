package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyChangeTest extends BaseTest {

    @Test
    public void changeCurrencyToUsd() {
        mainPage.openPage();
        headerPage.currencyChangeToUsd();
        Assert.assertEquals(headerPage.getCurrentCurrency(), "Валюта : USD", "Error");
    }

    @Test
    public void changeCurrencyToEur() {
        mainPage.openPage();
        headerPage.currencyChangeToEur();
        Assert.assertEquals(headerPage.getCurrentCurrency(), "Валюта : EUR", "Error");
    }
}
