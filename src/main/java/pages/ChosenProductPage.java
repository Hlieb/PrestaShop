package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

@Log4j2
public class ChosenProductPage extends BasePage{
    public ChosenProductPage(WebDriver driver) {
        super(driver);
    }

    public static final By ADD_TO_CART_BUTTON = By.id("add_to_cart");
    public static final By CHECKOUT_BUTTON = By.xpath("//*[contains(@class,'button-medium')]");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[contains(@class,'button exclusive-medium')]");
    public static final By TSHIRT_CATEGORY_BUTTON = By.xpath("//*[@title='T-shirts']");



    @Step("Clicking button 'Add to cart'")
    public ChosenProductPage addItemToCart(){
        log.info("Click 'Add to cart' button");
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    @Step("Clicking button 'Checkout'")
    public CartPage clickCheckoutButton(){
        Waiters.waitForElementLocated(driver,By.xpath("//*[contains(@class,'button-medium')]"), 5);
        log.info("Click 'Checkout' button");
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CartPage(driver);
    }

    @Step("Clicking button 'Continue'")
    public ChosenProductPage clickContinueShoppingButton(){
        Waiters.waitForElementLocated(driver,By.xpath("//*[contains(@class,'button exclusive-medium')]"), 5);
        log.info("Click 'Continue' button");
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return this;
    }
}
