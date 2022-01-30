package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

@Log4j2
public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public static final By ACCOUNT_CREATED_SUCCESSFULLY_MESSAGE = By.xpath("//*[@class = 'alert alert-success']");
    public static final By LOGOUT_BUTTON = By.xpath("//*[@class = 'logout']");

    public String getAccountCreatedSuccessfullyMessage(){
        Waiters.waitForElementLocated(driver,ACCOUNT_CREATED_SUCCESSFULLY_MESSAGE,5);
        return driver.findElement(ACCOUNT_CREATED_SUCCESSFULLY_MESSAGE).getText();
    }

    @Step("Click 'Logout' button")
    public CreateAccountOrSignInPage logout(){
        log.info("Clicking 'Logout' button");
        driver.findElement(LOGOUT_BUTTON).click();
        return new CreateAccountOrSignInPage(driver);
    }
}
