package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    // WebElements annotated with @FindBy for easy identification and interaction.

    @FindBy(xpath = "//div[@class='add-to-cart__button-wrapper']/button[contains(@class,'add-to-cart__button')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='success-popup__shopping-wrapper']//h3[@class='success-popup__success-message']")
    private WebElement addToCartPopupHeader;

    @FindBy(xpath = "//a[contains(text(),'Continue shopping')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[contains(text(),'Continue to cart')]")
    private WebElement continueToCartButton;

    // Constructor of the class, receives a WebDriver object and calls the constructor of the parent class (BasePage).
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Clicks the Add to Cart button using JavaScriptExecutor.
    public void clickAddToCartButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
    }

    // Returns the Add to Cart button WebElement.
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    // Checks if the Add to Cart popup is visible.
    public boolean isAddToCartPopupVisible() {
        return addToCartPopupHeader.isDisplayed();
    }

    // Checks if the Continue Shopping button is visible (but doesn't return the result).
    public void isContinueShoppingButtonVisible() {
        continueShoppingButton.isDisplayed();
    }

    // Gets the text of the Add to Cart popup header.
    public String getAddToCartPopupHeaderText() {
        return addToCartPopupHeader.getText();
    }

    // Checks if the Continue to Cart button is visible (but doesn't return the result).
    public void isContinueToCartButtonVisible() {
        continueToCartButton.isDisplayed();
    }

    // Clicks the Continue to Cart button.
    public void clickContinueToCartButton() {
        continueToCartButton.click();
    }

    // Returns the Add to Cart popup header WebElement.
    public WebElement getAddToCartPopupHeader() {
        return addToCartPopupHeader;
    }
}
