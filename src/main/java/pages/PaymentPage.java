package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public static final By PAYMENT_BY_CARD_BUTTON = By.xpath("//*[@class='bankwire']");
    public static final By PAYMENT_BY_CHECK_BUTTON = By.xpath("//*[@class='cheque']");
    public static final By SUBMIT_PAYMENT_BUTTON = By.xpath("//*[@class='button btn btn-default button-medium']");


    @Step("Click button 'Payment by cart'")
    public PaymentPage clickPaymentByCardButton() {
        log.info("Click button 'Payment by cart'");
        driver.findElement(PAYMENT_BY_CARD_BUTTON).click();
        return this;
    }

    @Step("Click button 'Payment by check'")
    public PaymentPage clickPaymentByCheckButton() {
        log.info("Click button 'Payment by check'");
        driver.findElement(PAYMENT_BY_CHECK_BUTTON).click();
        return this;
    }

    @Step("Click button 'Submit'")
    public OrderConfirmationPage clickSubmitPaymentButton() {
        log.info("Click button 'Submit'");
        driver.findElement(SUBMIT_PAYMENT_BUTTON).click();
        return new OrderConfirmationPage(driver);
    }
}
