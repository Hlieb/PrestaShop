package steps;

import org.openqa.selenium.WebDriver;
import pages.AddressPage;

public class ProvideAddressDetailsSteps {

    private AddressPage addressPage;


    public ProvideAddressDetailsSteps(WebDriver driver) {
        this.addressPage = new AddressPage(driver);
    }

    public void fillAllFields() {
        addressPage.fillFirstName("GLieb")
                .fillLastName("Boiechko")
                .fillAddressField("Gagarina 34")
                .fillPostCodeField("50555")
                .fillCityField("Grchkovo")
                .fillCountryField()
                .fillHomeNumberField("3423432432")
                .fillMobileNumberField("324324324")
                .fillStateField()
                .addressName("home")
                .clickSaveButton();
    }
}
