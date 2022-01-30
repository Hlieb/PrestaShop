package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

@Log4j2
public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final By DELETE_ITEM_BUTTON = By.xpath("//*[@title='Delete']");
    public static final By PRODUCTS_QUANTITY_MESSAGE = By.id("summary_products_quantity");
    public static final By PRODUCTS_QUANTITY_AT_THE_BASKET = By.xpath("//*[@class='ajax_cart_quantity']");
    public static final By INCREASE_PRODUCTS_QUANTITY_AT_THE_BASKET_BUTTON = By.xpath("//*[@title='Add']");
    public static final By CHANGE_PRODUCTS_QUANTITY_AT_THE_BASKET_FIELD = By.xpath("//*[@name ='quantity_1_1_0_0']");
    public static final By CHECKOUT_BUTTON = By.xpath("//*[@title='Proceed to checkout']");


    @Step("Clicking button 'Delete'")
    public CartPage deleteItem() {
        log.info("Click 'Delete' button");
        driver.findElement(DELETE_ITEM_BUTTON).click();
        return this;
    }

    public String getProductQuantityFromMessage() {
        Waiters.waitForElementLocated(driver, By.id("summary_products_quantity"), 10);
        Waiters.waitForPageLoaded();
        return driver.findElement(PRODUCTS_QUANTITY_MESSAGE).getText();
    }

    public String getProductQuantityFromCounter() {
       return driver.findElement(PRODUCTS_QUANTITY_AT_THE_BASKET).getText();
    }

    @Step("Clicking button '+' to increase product quantity")
    public CartPage increaseProductQuantityByButton(){
        log.info("Click '+' button");
        driver.findElement(INCREASE_PRODUCTS_QUANTITY_AT_THE_BASKET_BUTTON).click();
        return this;
    }

    public CartPage changeProductQuantityManually(String quantity){
        driver.findElement(CHANGE_PRODUCTS_QUANTITY_AT_THE_BASKET_FIELD).sendKeys(quantity);
        return this;
    }
    @Step("Clicking button 'Checkout'")
    public AddressPage clickCheckoutButton(){
        log.info("Click 'Checkout' button");
        driver.findElement(CHECKOUT_BUTTON).click();
        return new AddressPage(driver);
    }
}
