package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;


    public static final String BASE_URL = "http://prestashop.qatestlab.com.ua/ru";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Opening page '{URL}'")
    public void openPage(String URL) {
        driver.get(URL);
    }
}
