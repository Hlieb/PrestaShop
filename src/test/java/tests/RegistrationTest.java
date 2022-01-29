package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTest extends BaseTest {

    @Test
    public void fillAllRegistrationFieldsTest() {
        mainPage.openPage()
                .clickSignInButton()
                .createAnAccount("glebo@gmail.com")
                .chooseTitleMr()
                .fillFirstNameField("Hlieb")
                .fillLastNameField("Boiechko")
                .fillPasswordField("14081408")
                .clickRegistrationButton();
        Assert.assertEquals(myAccountPage.getAccountCreatedSuccessfullyMessage(), "Your account has been created.");
    }

    @Test
    public void fillOnlyRequiredRegistrationFieldsTest() {
        mainPage.openPage()
                .clickSignInButton()
                .createAnAccount("gleb@gmail.com")
                .fillFirstNameField("Hlieb")
                .fillLastNameField("Boiechko")
                .fillPasswordField("14081408")
                .clickRegistrationButton();
        Assert.assertEquals(myAccountPage.getAccountCreatedSuccessfullyMessage(), "Your account has been created.");
    }

    @Test
    public void fillOnlyNotRequiredRegistrationFieldsTest() {
        mainPage.openPage()
                .clickSignInButton()
                .createAnAccount("glb@gmail.com")
                .chooseTitleMr()
                .clickRegistrationButton();
        Assert.assertEquals(driver.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account#account-creation", "Error" );
    }
}
