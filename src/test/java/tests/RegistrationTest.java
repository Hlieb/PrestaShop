package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTest extends BaseTest {

    @Description("This test checks if user could register to website with correct data")
    @Test(description = "User fills all fields correctly", groups = {"smoke"})
    public void fillAllRegistrationFieldsTest() {
        mainPage.openPage()
                .clickSignInButton()
                .createAnAccount(createAccountOrSignInPage.generateRandomEmail())
                .chooseTitleMr()
                .fillFirstNameField("Hlieb")
                .fillLastNameField("Boiechko")
                .fillPasswordField("14081408")
                .clickRegistrationButton();
        Assert.assertEquals(myAccountPage.getAccountCreatedSuccessfullyMessage(), "Your account has been created.");
    }

    @Description("This test checks if user could register to website with correct data and filled only required fields")
    @Test(description = "User fills all required fields ", groups = {"smoke"})
    public void fillOnlyRequiredRegistrationFieldsTest() {
        mainPage.openPage()
                .clickSignInButton()
                .createAnAccount(createAccountOrSignInPage.generateRandomEmail())
                .fillFirstNameField("Hlieb")
                .fillLastNameField("Boiechko")
                .fillPasswordField("14081408")
                .clickRegistrationButton();
        Assert.assertEquals(myAccountPage.getAccountCreatedSuccessfullyMessage(), "Your account has been created.");
    }

    @Description("This test checks if user could register to website without filling required fields")
    @Test(description = "User fills only unrequired fields ", groups = {"smoke"})
    public void fillOnlyNotRequiredRegistrationFieldsTest() {
        mainPage.openPage()
                .clickSignInButton()
                .createAnAccount(createAccountOrSignInPage.generateRandomEmail())
                .chooseTitleMr()
                .clickRegistrationButton();
        Assert.assertEquals(registrationFormPage.getErrorMessage(), "There are 3 errors\n" + "lastname is required.\n" + "firstname is required.\n" + "passwd is required.", "Error" );
    }
}
