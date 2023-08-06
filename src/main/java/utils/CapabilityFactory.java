package utils;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {

    // Capabilities instance to hold the browser options.
    private Capabilities capabilities;

    // Method to get the Capabilities based on the specified browser.
    public Capabilities getCapabilities(String browser) {
        if (browser.equals("firefox")) {
            // Get Firefox options using OptionsManager.
            capabilities = OptionsManager.getFirefoxOptions();
        } else {
            // Get Chrome options using OptionsManager (assuming the default option for non-Firefox browsers is Chrome).
            capabilities = OptionsManager.getChromeOptions();
        }
        return capabilities;
    }

}
