package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;
import utils.CapabilityFactory;

public class BaseTest {

    // ThreadLocal to manage a separate WebDriver instance for each thread.
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    // CapabilityFactory instance to get browser capabilities.
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    // URL of the website under test.
    private static final String FRANCE_UP_URL = "https://franceup.com.ua/";

    // Method to set up the WebDriver instance with specified browser capabilities before each test method.
    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        // Create a new RemoteWebDriver with specified browser capabilities and set it the current WebDriver instance.
        driver.set(new RemoteWebDriver(
                new URL("http://192.168.31.195:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        // Maximize the browser window and navigate to the website under test.
        getDriver().manage().window().maximize();
        getDriver().get(FRANCE_UP_URL);
    }

    // Method to close the browser window after each test method.
    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    // Method to remove the WebDriver instance from the ThreadLocal after the test class is executed.
    @AfterClass
    void terminate() {
        driver.remove();
    }

    // Method to get the current WebDriver instance for the current thread.
    public WebDriver getDriver() {
        return driver.get();
    }

    // Methods to instantiate and return page objects for different pages.

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(getDriver());
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(getDriver());
    }

    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(getDriver());
    }

}
