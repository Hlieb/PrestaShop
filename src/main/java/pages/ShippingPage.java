package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ShippingPage extends BasePage{
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public static final By TERMS_AGREEMENT_BUTTON = By.id("uniform-cgv");
    public static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//*[@name='processCarrier']");


    @Step("Click button 'Terms agreement")
    public ShippingPage clickTermsAgreement(){
        log.info("Agree with 'Terms agreement");
        driver.findElement(TERMS_AGREEMENT_BUTTON).click();
        return this;
    }

    @Step("Click button 'Proceed to Checkout'")
    public PaymentPage clickProceedToCheckoutButton(){
        log.info("Click button 'Proceed to Checkout'");
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
        return new PaymentPage(driver);
    }
}
