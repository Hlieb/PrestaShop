package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddressPage extends BasePage{
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public static final By FIRST_NAME_FIELD = By.xpath("//*[@id='firstname']");
    public static final By LAST_NAME_FIELD = By.xpath("//*[@id='lastname']");
    public static final By ADDRESS_FIELD = By.xpath("//*[@id='address1']");
    public static final By ZIP_CODE_FIELD = By.xpath("//*[@id='postcode']");
    public static final By CITY_FIELD = By.xpath("//*[@id='city']");
    public static final By COUNTRY_FIELD = By.xpath("//*[@id='id_country']");
    public static final By HOME_PHONE_NUMBER_FIELD = By.xpath("//*[@id='phone']");
    public static final By MOBILE_PHONE_NUMBER_FIELD = By.xpath("//*[@id='phone_mobile']");
    public static final By STATE_FIELD = By.xpath("//*[@id='id_state']");
    public static final By ADDRESS_NAME_FIELD = By.xpath("//*[@id='alias']");
    public static final By SAVE_BUTTON = By.xpath("//*[@id='submitAddress'[");
    public static final By CHOOSE_UKRAINE = By.xpath("//*[contains(text(),'Украина')]");
    public static final By CHOOSE_USA = By.xpath("//*[contains(text(),'США')]");
    public static final By CHOOSE_STATE = By.xpath("//*[contains(text(),'Черкасская область')]");
    public static final By ADD_ADDRESS_BUTTON = By.xpath("//*[@class='address_add submit']");


    @Step("Filling field '{name}'")
    public AddressPage fillFirstName(String name){
        log.info("Filling 'Name' field");
        driver.findElement(FIRST_NAME_FIELD).sendKeys(name);
        return this;
    }

    @Step("Click button 'Add address'")
    public AddressPage provideNewShippingAddress(){
        log.info("Click button 'Add address'");
        driver.findElement(ADD_ADDRESS_BUTTON).click();
        return this;
    }

    @Step("Filling field '{lastname}'")
    public AddressPage fillLastName(String lastname){
        log.info("Filling 'Lastname' field");
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastname);
        return this;
    }

    @Step("Filling field '{address}'")
    public AddressPage fillAddressField(String address){
        log.info("Filling 'Address' field");
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
        return this;
    }

    @Step("Filling field '{postcode}'")
    public AddressPage fillPostCodeField(String postCode){
        log.info("Filling 'postcode' field");
        driver.findElement(ZIP_CODE_FIELD).sendKeys(postCode);
        return this;
    }

    @Step("Filling field '{city}'")
    public AddressPage fillCityField(String city){
        log.info("Filling 'city' field");
        driver.findElement(CITY_FIELD).sendKeys(city);
        return this;
    }

    @Step("Choose country from the dropbox")
    public AddressPage fillCountryField(){
        log.info("Click at the dropbox 'Country'");
        driver.findElement(COUNTRY_FIELD).click();
        log.info("Choose 'Ukraine'");
        driver.findElement(CHOOSE_UKRAINE).click();
        return this;
    }

    @Step("Filling field '{number}'")
    public AddressPage fillHomeNumberField(String number){
        log.info("Filling 'Home number' field");
        driver.findElement(HOME_PHONE_NUMBER_FIELD).sendKeys(number);
        return this;
    }

    @Step("Filling field '{mobileNumber}'")
    public AddressPage fillMobileNumberField(String mobileNumber){
        log.info("Filling 'Mobile number' field");
        driver.findElement(MOBILE_PHONE_NUMBER_FIELD).sendKeys(mobileNumber);
        return this;
    }

    @Step("Choose state from the dropbox")
    public AddressPage fillStateField(){
        log.info("Click at the dropbox 'State'");
        driver.findElement(STATE_FIELD).click();
        log.info("Choose 'State'");
        driver.findElement(CHOOSE_STATE).click();
        return this;
    }

    @Step("Filling field '{name}'")
    public AddressPage addressName(String name) {
        log.info("Filling 'Address Name' field");
        driver.findElement(ADDRESS_NAME_FIELD).sendKeys(name);
        return this;
    }

    @Step("Clicking button 'Save'")
    public AllAddressesPage clickSaveButton() {
        log.info("Click 'Save' button");
        driver.findElement(SAVE_BUTTON).click();
        return new AllAddressesPage(driver);
    }
}
