package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {

    // Default waiting time for page load and Ajax completion.
    private static final long DEFAULT_WAITING_TIME = 90;

    @Test
    public void checkMainComponentsOnHomePage() {
        // Test to check various main components on the home page.

        // Wait for page load and Ajax completion.
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);

        // Assertions to check visibility of various main components.
        assertTrue(getHomePage().isHeaderVisible());
        assertTrue(getHomePage().isFooterVisible());
        assertTrue(getHomePage().isSearchFieldVisible());
        assertTrue(getHomePage().isCartIconVisible());
        assertTrue(getHomePage().isRegisterButtonVisible());
        assertTrue(getHomePage().isSignInButtonVisible());

        // Perform interactions with the sign-in popup.
        getHomePage().clickSignInButton();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getSignInPopup());
        assertTrue(getHomePage().isEmailFieldVisible());
        assertTrue(getHomePage().isPasswordFieldVisible());
        getHomePage().clickSignInPopupCloseButton();

        // Wait for Ajax completion after interacting with the sign-in popup.
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);

        // Click on the store button and check the store popup visibility.
        getHomePage().clickStoreButton();
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        assertTrue(getHomePage().isStorePopupVisible());

        // Click on the cart icon and check the shopping cart page title visibility.
        getHomePage().clickCartButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getShoppingCartPage().getShoppingCartTitle());
        assertTrue(getShoppingCartPage().isShoppingCartTitleVisible());

        // Click on the language button and wait for Ajax completion.
        getHomePage().clickLanguageButton();
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
    }

    @Test
    public void checkWishList() throws InterruptedException {
        // Test to check the functionality of adding a product to the wishlist.

        // Wait for page load and Ajax completion.
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);

        // Perform a search and click on the wishlist icon of the first product.
        getHomePage().isSearchFieldVisible();
        getHomePage().enterTextToSearchField("cake");
        getSearchResultsPage().clickWishListOnFirstProduct();

        // Wait for page load and Ajax completion.
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);

        // Check the wishlist products count.
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getWishListProductsCount());
        assertEquals(getHomePage().getAmountOfProductsInWishList(), "1");
    }

    @Test
    public void checkAddToCart() {
        // Test to check the functionality of adding a product to the shopping cart.

        // Wait for page load and Ajax completion.
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);

        // Perform a search and click on the "Add to Cart" button of the product.
        getHomePage().isSearchFieldVisible();
        getHomePage().enterTextToSearchField("0830187p");
        getProductPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getProductPage().getAddToCartButton());
        getProductPage().clickAddToCartButton();

        // Wait for the "Add to Cart" popup to appear and check its visibility.
        getProductPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getProductPage().getAddToCartPopupHeader());
        assertTrue(getProductPage().isAddToCartPopupVisible());

        // Check the visibility of "Continue Shopping" and "Continue to Cart" buttons in the popup.
        getProductPage().isContinueShoppingButtonVisible();
        getProductPage().isContinueToCartButtonVisible();

        // Check the text of the "Add to Cart" popup header.
        assertEquals(getProductPage().getAddToCartPopupHeaderText(), "You have added 1 item(s) to your cart");

        // Click on the "Continue to Cart" button and proceed to checkout.
        getProductPage().clickContinueToCartButton();
        getShoppingCartPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getShoppingCartPage().getShoppingCartItem());
        getShoppingCartPage().clickCheckoutButton();

        // Wait for the payment cart button and check the visibility of the payment and billing forms.
        getShoppingCartPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getCheckoutPage().getPaymentCartButton());
        getCheckoutPage().clickPaymentCartButton();
        getShoppingCartPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getCheckoutPage().getPaymentForm());
        assertTrue(getCheckoutPage().isPaymentFormVisible());
        assertTrue(getCheckoutPage().isBillingFormVisible());
        assertTrue(getCheckoutPage().isCompleteOrderButtonVisible());
    }
}
