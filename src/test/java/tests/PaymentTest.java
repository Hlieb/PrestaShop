package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {

    @Test
    public void checkoutWithFilledRequiredFields() {
        logInSteps.logIn();
        addFadedShortsToCart.addShorts();
        cartPage.clickCheckoutButton()
                .provideNewShippingAddress();
        provideAddressDetailsSteps.fillAllFields();
        allAddressesPage.clickCheckoutButton()
                .clickTermsAgreement()
                .clickProceedToCheckoutButton()
                .clickPaymentByCardButton()
                .clickSubmitPaymentButton();
        Assert.assertEquals(orderConfirmationPage.getConfirmationMessage(), "Ваш заказ http://prestashop.qatestlab.com.ua/ выполнен.", "error");
    }
}
