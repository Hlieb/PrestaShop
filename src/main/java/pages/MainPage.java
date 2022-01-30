package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MainPage extends BasePage {

    public static final String SIGN_IN = "//*[@class = 'header_user_info']";
    public static final By SEARCH_FIELD = By.id("search_query_top");
    public static final By SEARCH_BUTTON = By.xpath("//*[@name='submit_search']");
    public static final By WOMAN_CATEGORY_BUTTON = By.xpath("//*[@title='Women']");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openPage() {
        openPage(BASE_URL);
        return this;
    }

    @Step("Click 'Sing in' button")
    public CreateAccountOrSignInPage clickSignInButton() {
        log.info("Click 'Sing in' button");
        driver.findElement(By.xpath(SIGN_IN)).click();
        return new CreateAccountOrSignInPage(driver);
    }

    @Step("Search product by keyword '{itemName}'")
    public MainPage searchByKeyWord(String itemName) {
        log.info("Searching product by the keyword");
        driver.findElement(SEARCH_FIELD).sendKeys(itemName);
        return this;
    }

    @Step("Click at the 'Search' button")
    public ItemPage clickAtSearchButton() {
        log.info("Click at the button 'Search'");
        driver.findElement(SEARCH_BUTTON).click();
        return new ItemPage(driver);
    }

    @Step("Click at the 'Woman category' button")
    public ItemPage clickAtWomanCategoryButton(){
        log.info("Click at the button 'Woman category'");
        driver.findElement(WOMAN_CATEGORY_BUTTON).click();
        return new ItemPage(driver);
    }
}


