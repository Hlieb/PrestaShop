package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {

    @Description("This test checks if user could provide payment")
    @Test(description = "User fills all fields correctly, and try to pay for his items", groups = {"smoke"})
    public void checkoutWithFilledRequiredFields() {
        logInSteps.logIn();
        addFadedShortsToCart.addShorts();
        cartPage.clickCheckoutButton()
                .clickAddAddressButton();
        provideAddressDetailsSteps.fillAllFields();
        allAddressesPage.clickCheckoutButton()
                .clickTermsAgreement()
                .clickProceedToCheckoutButton()
                .clickPaymentByCardButton()
                .clickSubmitPaymentButton();
        Assert.assertEquals(orderConfirmationPage.getConfirmationMessage(), "Ваш заказ http://prestashop.qatestlab.com.ua/ выполнен.", "error");
    }
}
