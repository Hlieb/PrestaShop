package steps;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.ChosenProductPage;
import pages.ItemPage;
import pages.MainPage;

public class AddFadedShortsToCart {
    private MainPage mainPage;
    private ItemPage itemPage;
    private ChosenProductPage chosenProductPage;

    public AddFadedShortsToCart(WebDriver driver) {
        this.mainPage = new MainPage(driver);
        this.itemPage = new ItemPage(driver);
        this.chosenProductPage = new ChosenProductPage(driver);
    }

    public void addShorts() {
        mainPage.openPage()
                .clickAtWomanCategoryButton();
        itemPage.chooseFadedShort();
        chosenProductPage.addItemToCart()
                .clickCheckoutButton();

    }
}
