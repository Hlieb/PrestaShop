package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void fillAllFieldsCorrectlyTest() {
        mainPage.openPage()
                .clickSignInButton()
                .fillEmailLogin(EMAIL)
                .fillPasswordLogin(PASSWORD)
                .clickLogInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account", "Error");
    }

    @Test
    public void fillOnlyEmailLoginFieldTest() {
        mainPage.openPage()
                .clickSignInButton()
                .fillEmailLogin(EMAIL)
                .clickLogInButton();
        Assert.assertEquals(createAccountOrSignInPage.getLoginErrorMessage(), "There is 1 error\n" + "Password is required.", "Error");
    }

    @Test
    public void noLoginFieldsFilledTest() {
        mainPage.openPage()
                .clickSignInButton()
                .clickLogInButton();
        Assert.assertEquals(createAccountOrSignInPage.getLoginErrorMessage(), "There is 1 error\n" + "An email address required.", "Error");
    }

    @Test
    public void putIncorrectDataTest() {
        mainPage.openPage()
                .clickSignInButton()
                .fillEmailLogin("ewrewr@gsdg.ru")
                .fillPasswordLogin("wefewf")
                .clickLogInButton();
        Assert.assertEquals(createAccountOrSignInPage.getLoginErrorMessage(), "There is 1 error\n" + "Authentication failed.", "Error");
    }
}

