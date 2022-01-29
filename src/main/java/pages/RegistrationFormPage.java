package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

@Log4j2
public class RegistrationFormPage extends BasePage {
    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }
    public static final By TITLE_MR = By.id("id_gender1");
    public static final By TITLE_MRS = By.id("id_gender2");
    public static final By FIRST_NAME = By.id("customer_firstname");
    public static final By LAST_NAME = By.id("customer_lastname");
    public static final By PASSWORD = By.id("passwd");
    public static final By REGISTER_BUTTON = By.id("submitAccount");

    @Step("At the registration form choose title Mr.")
    public RegistrationFormPage chooseTitleMr(){
        Waiters.waitForElementLocated(driver,By.id("id_gender1"),5);
        log.info("At the registration form choose title Mr.");
        driver.findElement(TITLE_MR).click();
        return this;
    }

    @Step("At the registration form choose title Mrs.")
    public RegistrationFormPage chooseTitleMrs(){
        Waiters.waitForElementLocated(driver,By.id("id_gender1"),5);
        log.info("At the registration form choose title Mrs.");
        driver.findElement(TITLE_MRS).click();
        return this;
    }

    @Step("Fill field 'First name' with '{name}'")
    public RegistrationFormPage fillFirstNameField(String name){
        Waiters.waitForElementLocated(driver,By.id("customer_firstname"),5);
        log.info("Fill field 'First name'");
        driver.findElement(FIRST_NAME).sendKeys(name);
        return this;
    }

    @Step("Fill field 'Last name' with '{lastName}'")
    public RegistrationFormPage fillLastNameField(String lastName){
        log.info("Fill field 'Last name'");
        driver.findElement(LAST_NAME).sendKeys(lastName);
        return this;
    }

    @Step("Fill field 'Password' with '{password}'")
    public RegistrationFormPage fillPasswordField(String password){
        log.info("Fill field 'Password'");
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    @Step("Click button 'Register'")
    public MyAccountPage clickRegistrationButton(){
        log.info("Click 'Register' button");
        driver.findElement(REGISTER_BUTTON).click();
        return new MyAccountPage(driver);
    }
}
