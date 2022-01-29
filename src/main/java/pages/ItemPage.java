package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ItemPage extends BasePage{
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public static final By SEARCHED_NAME_ITEM_INFORMATION_MESSAGE = By.xpath("//*[@class='lighter']");
    public static final By NUMBER_OF_FOUND_ITEMS_MESSAGE = By.xpath("//*[@class='heading-counter']");
    public static final By CHOOSE_FADED_SHORT = By.xpath("//*[@title='Faded Short Sleeve T-shirts']");
    public static final By PRINTED_SUMMER_DRESS = By.xpath("//*[@title='Printed Dress']");



    public String getKeyWord(){
       return driver.findElement(SEARCHED_NAME_ITEM_INFORMATION_MESSAGE).getText();
    }

    public String getNumberOfFoundedItems(){
        return driver.findElement(NUMBER_OF_FOUND_ITEMS_MESSAGE).getText();
    }

    @Step("Choose product 'Faded short'")
    public ChosenProductPage chooseFadedShort(){
        log.info("Choose product 'Faded short'");
        driver.findElement(CHOOSE_FADED_SHORT).click();
        return new ChosenProductPage(driver);
    }

    @Step("Choose product 'Printed summer dress'")
    public ChosenProductPage choosePrintedSummerDress(){
        log.info("Choose product 'Printed summer dress'");
        driver.findElement(PRINTED_SUMMER_DRESS).click();
        return new ChosenProductPage(driver);
    }
}
