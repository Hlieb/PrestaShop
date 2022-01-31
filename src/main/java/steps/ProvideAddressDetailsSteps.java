package steps;

import org.openqa.selenium.WebDriver;
import pages.AddressPage;
import utils.Waiters;

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
                .fillHomeNumberField("34234232432")
                .fillMobileNumberField("3243243324")
                .fillStateField()
                .addressName("home")
                .clickSaveButton();
    }
}
