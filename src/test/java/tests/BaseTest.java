package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.AddFadedShortsToCart;
import steps.LogInSteps;
import steps.ProvideAddressDetailsSteps;
import tests.utils.PropertyReader;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    CreateAccountOrSignInPage createAccountOrSignInPage;
    RegistrationFormPage registrationFormPage;
    MyAccountPage myAccountPage;
    HeaderPage headerPage;
    ItemPage itemPage;
    AddressPage addressPage;
    ChosenProductPage chosenProductPage;
    CartPage cartPage;
    AddFadedShortsToCart addFadedShortsToCart;
    LogInSteps logInSteps;
    AllAddressesPage allAddressesPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderConfirmationPage orderConfirmationPage;
    ProvideAddressDetailsSteps provideAddressDetailsSteps;
    protected static final String EMAIL = System.getProperty("EMAIL", PropertyReader.getProperty("EMAIL"));
    protected static final String PASSWORD = System.getProperty("PASSWORD", PropertyReader.getProperty("PASSWORD"));

    @BeforeMethod
    public void initTest(ITestContext context) {
        initBrowser();
        initPages();
        String driverVariable = "driver";
        context.setAttribute(driverVariable, driver);
    }

    public void initPages() {
        mainPage = new MainPage(driver);
        createAccountOrSignInPage = new CreateAccountOrSignInPage(driver);
        registrationFormPage = new RegistrationFormPage(driver);
        myAccountPage = new MyAccountPage(driver);
        headerPage = new HeaderPage(driver);
        itemPage = new ItemPage(driver);
        chosenProductPage = new ChosenProductPage(driver);
        cartPage = new CartPage(driver);
        addFadedShortsToCart = new AddFadedShortsToCart(driver);
        logInSteps = new LogInSteps(driver);
        addressPage = new AddressPage(driver);
        allAddressesPage = new AllAddressesPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        provideAddressDetailsSteps = new ProvideAddressDetailsSteps(driver);
    }

    public void initBrowser() {
        if (System.getProperty("browser") != null) {
            if (System.getProperty("browser").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (System.getProperty("browser").equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (System.getProperty("browser").equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
