package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

@Log4j2
public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public static final By LANGUAGE_CHANGE_BUTTON = By.xpath("//*[@id='languages-block-top']");
    public static final By CURRENT_LANGUAGE = By.xpath("//*[@id='languages-block-top']/*[@class='current']");
    public static final By UKRAINIAN_LANGUAGE = By.xpath("//*[@id='languages-block-top']//*[contains(text(),'Українська')]");
    public static final By ENGLISH_LANGUAGE = By.xpath("//*[@id='languages-block-top']//*[contains(text(),'English')]");
    public static final By CURRENCY_CHANGE_BUTTON = By.xpath("//*[@id='currencies-block-top']");
    public static final By CURRENCY_EURO = By.xpath("//*[@id='currencies-block-top']//*[contains(text(),'Евро')]");
    public static final By CURRENCY_DOLLAR = By.xpath("//*[@id='currencies-block-top']//*[contains(text(),'Доллар')]");
    public static final By CURRENT_CURRENCY = By.xpath("//*[@id='currencies-block-top']//*[@class='current']");


    @Step("Change language to the Ukrainian'")
    public HeaderPage languageChangeToUkr() {
        log.info("Click at the 'language change' button");
        driver.findElement(LANGUAGE_CHANGE_BUTTON).click();
        Waiters.waitForElementLocated(driver,By.xpath("//*[@id='languages-block-top']//*[contains(@title,'Ukrainian')]"), 5);
        log.info("Click at the 'Ukrainian language' button");
        driver.findElement(UKRAINIAN_LANGUAGE).click();
        return this;
    }

    @Step("Change language to the English'")
    public HeaderPage languageChangeToEng() {
        log.info("Click at the 'language change' button");
        driver.findElement(LANGUAGE_CHANGE_BUTTON).click();
        Waiters.waitForElementLocated(driver,By.xpath("//*[@id='languages-block-top']//*[contains(text(),'English')]"), 5);
        log.info("Click at the 'English language' button");
        driver.findElement(ENGLISH_LANGUAGE).click();
        return this;
    }

    public String getCurrentLanguage() {
        return driver.findElement(CURRENT_LANGUAGE).getText();
    }

    public String getCurrentCurrency() {
        return driver.findElement(CURRENT_CURRENCY).getText();
    }

    @Step("Change language to the USD'")
    public HeaderPage currencyChangeToUsd() {
        log.info("Click at the 'currency change' button");
        driver.findElement(CURRENCY_CHANGE_BUTTON).click();
        Waiters.waitForElementLocated(driver,By.xpath("//*[@id='currencies-block-top']//*[contains(text(),'Доллар')]"), 5);
        log.info("Click at the 'USD' button");
        driver.findElement(CURRENCY_DOLLAR).click();
        Waiters.waitForElementLocated(driver,By.xpath("//*[@id='currencies-block-top']//*[@class='current']"), 5);
        return this;
    }

    @Step("Change language to the EUR'")
    public HeaderPage currencyChangeToEur() {
        log.info("Click at the 'currency change' button");
        driver.findElement(CURRENCY_CHANGE_BUTTON).click();
        Waiters.waitForElementLocated(driver,By.xpath("//*[@id='currencies-block-top']//*[contains(text(),'Евро')]"), 5);
        log.info("Click at the 'EUR' button");
        driver.findElement(CURRENCY_EURO).click();
        Waiters.waitForElementLocated(driver,By.xpath("//*[@id='currencies-block-top']//*[@class='current']"), 5);
        return this;
    }
}
