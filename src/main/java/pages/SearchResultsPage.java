package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    // List of WebElements annotated with @FindBy for easy identification and interaction.

    @FindBy(xpath = "//button[contains(@class, 'heart-icon')]")
    private List<WebElement> wishListIcons;

    // Constructor of the class, receives a WebDriver object and calls the constructor of the parent class (BasePage).
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    // Clicks the Wishlist icon on the first product in the search results.
    public void clickWishListOnFirstProduct() {
        wishListIcons.get(0).click();
    }
}
