package steps;

import org.openqa.selenium.WebDriver;
import pages.CreateAccountOrSignInPage;
import pages.MainPage;

public class LogInSteps {

    private MainPage mainPage;
    private CreateAccountOrSignInPage createAccountOrSignInPage;

    public LogInSteps(WebDriver driver) {
        this.mainPage = new MainPage(driver);
        this.createAccountOrSignInPage = new CreateAccountOrSignInPage(driver);
    }

    public void logIn() {
        mainPage.openPage()
                .clickSignInButton()
                .fillEmailLogin("Glebon9767@gmail.com")
                .fillPasswordLogin("14081408")
                .clickLogInButton();
    }
}
