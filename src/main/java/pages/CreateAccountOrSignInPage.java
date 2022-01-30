package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

@Log4j2
public class CreateAccountOrSignInPage extends BasePage {


    private static final By CREATE_AN_ACCOUNT_BUTTON = By.id("SubmitCreate");
    private static final By EMAIL_ADDRESS_CREATE_FIELD = By.id("email_create");
    private static final By LOGIN_BUTTON = By.id("SubmitLogin");
    private static final By LOGIN_EMAIL_FIELD = By.id("email");
    private static final By LOGIN_PASSWORD_FIELD = By.id("passwd");
    public static final By LOGIN_ERROR_MESSAGE = By.xpath("//*[@class = 'alert alert-danger']");
    private static final By LOGIN_PAGE_MESSAGE = By.xpath("//*[@id='login_form']/*");



    public CreateAccountOrSignInPage(WebDriver driver) {
        super(driver);

    }

    public String getLoginFormMessage(){
        return driver.findElement(LOGIN_PAGE_MESSAGE).getText();
    }

    @Step("Fill field 'Email' with '{email}'")
    public RegistrationFormPage createAnAccount(String email) {
        log.info("Fill 'Email' field");
        driver.findElement(EMAIL_ADDRESS_CREATE_FIELD).sendKeys(email);
        log.info("Click 'Create an account' button");
        driver.findElement(CREATE_AN_ACCOUNT_BUTTON).click();
        return new RegistrationFormPage(driver);
    }

    @Step("Fill field 'Email' with '{email}'")
    public CreateAccountOrSignInPage fillEmailLogin(String email) {
        log.info("Fill 'Email' field");
        driver.findElement(LOGIN_EMAIL_FIELD).sendKeys(email);
        return this;
    }

    @Step("Fill field 'Email' with '{password}'")
    public CreateAccountOrSignInPage fillPasswordLogin(String password) {
        log.info("Fill 'Password' field");
        driver.findElement(LOGIN_PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    @Step("Click 'Login' Button")
    public MyAccountPage clickLogInButton() {
        log.info("Click 'Login' button");
        driver.findElement(LOGIN_BUTTON).click();
        return new MyAccountPage(driver);
    }

    public String getLoginErrorMessage(){
        Waiters.waitForElementLocated(driver,By.xpath("//*[@class = 'alert alert-danger']"),5);
        return driver.findElement(LOGIN_ERROR_MESSAGE).getText();
    }
}
