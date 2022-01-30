package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage{
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public static final By ORDER_CONFIRMATION_MESSAGE = By.xpath("//*[@class='cheque-indent']");

    public String getConfirmationMessage(){
        return driver.findElement(ORDER_CONFIRMATION_MESSAGE).getText();
    }
}
