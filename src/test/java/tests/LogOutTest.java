package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    @Description("This test checks if user could logout from the website")
    @Test(description = "User logouts from the website", groups = {"smoke"})
    public void signOutTest(){
        mainPage.openPage()
                .clickSignInButton()
                .fillEmailLogin(EMAIL)
                .fillPasswordLogin(PASSWORD)
                .clickLogInButton()
                .logout();
        Assert.assertEquals(createAccountOrSignInPage.getLoginFormMessage(),"ALREADY REGISTERED?", "Error");
    }
}
