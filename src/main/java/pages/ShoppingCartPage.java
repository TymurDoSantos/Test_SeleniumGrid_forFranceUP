package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    // WebElements annotated with @FindBy for easy identification and interaction.

    @FindBy(xpath = "//h1[@class='checkout-header__heading']")
    private WebElement shoppingCartTitle;

    @FindBy(xpath = "//button[@class='checkout-order-summary__continue-btn']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[contains(@class, 'shopping-cart-item--shopping-cart-your-order')]|//section[@data-code or @data-product-code]")
    private WebElement shoppingCartItem;

    // Constructor of the class, receives a WebDriver object and calls the constructor of the parent class (BasePage).
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // Returns the WebElement representing the Shopping Cart title.
    public WebElement getShoppingCartTitle() {
        return shoppingCartTitle;
    }

    // Checks if the Shopping Cart title is visible.
    public boolean isShoppingCartTitleVisible() {
        return shoppingCartTitle.isDisplayed();
    }

    // Clicks the Checkout button.
    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    // Returns the WebElement representing the Shopping Cart item.
    public WebElement getShoppingCartItem() {
        return shoppingCartItem;
    }

}
