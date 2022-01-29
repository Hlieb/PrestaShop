package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    @Test
    public void signOutTest(){
        mainPage.openPage()
                .clickSignInButton()
                .fillEmailLogin("Glebon9767@gmail.com")
                .fillPasswordLogin("14081408")
                .clickLogInButton()
                .logout();
        Assert.assertEquals(createAccountOrSignInPage.getLoginFormMessage(),"ALREADY REGISTERED?", "Error");
    }
}
