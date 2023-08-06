package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // WebElements annotated with @FindBy for easy identification and interaction.

    @FindBy(xpath = "//header[contains(@class, 'global-header global-header--sticky') or @class='page-header']")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = ".//a[@class='global-header__main-bar__utility-nav__user-cart__link']")
    private WebElement cartIcon;

    @FindBy(xpath = ".//a[contains(@class, 'header-top-bar__input__language')]/span")
    private WebElement languageButton;

    @FindBy(xpath = "//button[contains(@class,'enterprise-account__button_sign-in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//button[contains(@class, 'enterprise-account__button_register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='gigya-screen-dialog-main']")
    private WebElement signInPopup;

    @FindBy(xpath = ".//input[@name='username'][@placeholder='Email *']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@name='password'][contains(@placeholder, '*')]")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='gigya-screen-dialog-close']")
    private WebElement signInPopupCloseButton;

    @FindBy(xpath = "//div[@class='header-store parbase']//span[contains(@class,'global-store__content__section__store-name')]")
    private WebElement storeButton;

    @FindBy(xpath = "//div[@class='global-store__popup-wrapper']//div[@class='store-search']")
    private WebElement storePopup;

    @FindBy(xpath = "//input[@id='global-atlas-search__input']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='global-search__submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'wishlist-button')]//div[contains(@class,'items-count')]")
    private WebElement wishListProductsCount;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Methods to interact with the page elements and get their visibility, text, or attributes.

    public boolean isHeaderVisible() {
        return header.isDisplayed();
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }

    public boolean isCartIconVisible() {
        return cartIcon.isDisplayed();
    }

    public String getLanguageButtonText() {
        return languageButton.getText();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isRegisterButtonVisible() {
        return registerButton.isDisplayed();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public WebElement getSignInPopup() {
        return signInPopup;
    }

    public void clickSignInPopupCloseButton() {
        // Clicks the sign-in popup close button using JavaScriptExecutor.
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInPopupCloseButton);
    }

    public void clickStoreButton() {
        storeButton.click();
    }

    public boolean isStorePopupVisible() {
        return storePopup.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void clickCartButton() {
        cartIcon.click();
    }

    public void clickLanguageButton() {
        languageButton.click();
    }

    public void enterTextToSearchField(final String searchText) {
        // Clears the search field and enters the provided text, then presses Enter.
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER);
    }

    public WebElement getWishListProductsCount() {
        return wishListProductsCount;
    }

    public String getAmountOfProductsInWishList() {
        return wishListProductsCount.getText();
    }

}
