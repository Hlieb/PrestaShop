package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AllAddressesPage extends BasePage{
    public AllAddressesPage(WebDriver driver) {
        super(driver);
    }

    public static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//*[@name='processAddress']");

    @Step("Clicking button 'Checkout''")
    public ShippingPage clickCheckoutButton(){
        log.info("Click 'Checkout' button");
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
        return new ShippingPage(driver);
    }
}
