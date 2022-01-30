package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Description("This test checks if user could login to website with correct data")
    @Test(description = "User fills all fields correctly", groups = {"smoke"})
    public void fillAllFieldsCorrectlyTest() {
        mainPage.openPage()
                .clickSignInButton()
                .fillEmailLogin(EMAIL)
                .fillPasswordLogin(PASSWORD)
                .clickLogInButton();
        Assert.assertEquals(basePage.getCurrentUrl(), "http://prestashop.qatestlab.com.ua/ru/my-account", "Error");
    }

    @Description("This test checks if user could login to website with only filled 'Email' field")
    @Test(description = "User fills only field 'Email'", groups = {"smoke"})
    public void fillOnlyEmailLoginFieldTest() {
        mainPage.openPage()
                .clickSignInButton()
                .fillEmailLogin(EMAIL)
                .clickLogInButton();
        Assert.assertEquals(createAccountOrSignInPage.getLoginErrorMessage(), "There is 1 error\n" + "Password is required.", "Error");
    }

    @Description("This test checks if user could login to website without any filled fields")
    @Test(description = "User doesn't fill any field", groups = {"smoke"})
    public void noLoginFieldsFilledTest() {
        mainPage.openPage()
                .clickSignInButton()
                .clickLogInButton();
        Assert.assertEquals(createAccountOrSignInPage.getLoginErrorMessage(), "There is 1 error\n" + "An email address required.", "Error");
    }

    @Description("This test checks if user could login to website with incorrect data")
    @Test(description = "User fills all fields with invalid data", groups = {"smoke"})
    public void putIncorrectDataTest() {
        mainPage.openPage()
                .clickSignInButton()
                .fillEmailLogin("ewrewr@gsdg.ru")
                .fillPasswordLogin("wefewf")
                .clickLogInButton();
        Assert.assertEquals(createAccountOrSignInPage.getLoginErrorMessage(), "There is 1 error\n" + "Authentication failed.", "Error");
    }
}

