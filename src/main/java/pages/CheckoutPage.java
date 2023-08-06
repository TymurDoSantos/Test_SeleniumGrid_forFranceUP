package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    // WebElements annotated with @FindBy for easy identification and interaction.

    @FindBy(xpath = "//button[contains(@class,'choose-payment-method__btn--regular-card')]")
    private WebElement paymentCartButton;

    @FindBy(xpath = "//*[@class='opc-billing-form']/*[@class='opc-billing-form__wrapper']")
    private WebElement billingForm;

    @FindBy(xpath = "//div[@class='checkout-payment-form__wrapper']")
    private WebElement paymentForm;

    @FindBy(xpath = "//button[contains(@class,'checkout-order-summary__continue-btn')]")
    private WebElement completeOrderButton;

    // Constructor of the class, receives a WebDriver object and calls the constructor of the parent class (BasePage).
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Clicks the Payment Cart button.
    public void clickPaymentCartButton() {
        paymentCartButton.click();
    }

    // Returns the Payment Cart button WebElement.
    public WebElement getPaymentCartButton() {
        return paymentCartButton;
    }

    // Returns the Payment Form WebElement.
    public WebElement getPaymentForm() {
        return paymentForm;
    }

    // Checks if the Billing Form is visible.
    public boolean isBillingFormVisible() {
        return billingForm.isDisplayed();
    }

    // Checks if the Payment Form is visible.
    public boolean isPaymentFormVisible() {
        return paymentForm.isDisplayed();
    }

    // Checks if the Complete Order button is visible.
    public boolean isCompleteOrderButtonVisible() {
        return completeOrderButton.isDisplayed();
    }

}
