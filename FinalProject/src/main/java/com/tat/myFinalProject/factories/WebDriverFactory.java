package com.tat.myFinalProject.factories;

import com.tat.myFinalProject.exceptions.UnrecognizedBrowser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * WebDriver factory. Allows you to get driver by driver Capabilities.
 *
 * @author Evgeniy Titenkov.
 */
public class WebDriverFactory {
    private static WebDriver driver;
    private static String key;

    /**
     * Return new WebDriver depend on driver Capabilities, if this driver is not created yet
     * or browser is dead or different flavour of WebDriver is required, else return current
     * WebDriver.
     *
     * @param startingUrl
     * @param capabilities - driver Capabilities.
     * @return WebDriver.
     */
    public static WebDriver getDriver(String startingUrl, Capabilities capabilities) {
        if (driver == null) {
            return newWebDriver(startingUrl, capabilities);
        }
        try {
            driver.getCurrentUrl();
        } catch (Throwable t) {
            t.printStackTrace();
            return newWebDriver(startingUrl, capabilities);
        }
        String newKey = capabilities.toString() + ":" + startingUrl;
        String currentKey = key + ":" + driver.getCurrentUrl();
        if (!newKey.equals(currentKey)) {
            closeDriver();
            key = capabilities.toString();
            return newWebDriver(startingUrl, capabilities);
        } else {
            return driver;
        }
    }

    /**
     * Overload of getDriver method, if you need to get driver without starting url.
     *
     * @param capabilities - driver Capabilities.
     * @return
     */
    public static WebDriver getDriver(Capabilities capabilities) {
        return getDriver(null, capabilities);
    }

    /**
     * Close WebDriver.
     */
    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.close();
                driver = null;
                key = null;
            } catch (WebDriverException ex) {
                // it can already be dead or unreachable
            }
        }
    }

    private static WebDriver newWebDriver(String startUrl, Capabilities capabilities) {
        driver = createLocalDriver(capabilities);
        key = capabilities.toString() + ":" + startUrl;
        if (startUrl != null) {
            driver.get(startUrl);
        }
        return driver;
    }

    private static WebDriver createLocalDriver(Capabilities capabilities) {
        String browserType = capabilities.getBrowserName();
        if (browserType.startsWith("internet explorer")) {
            return new InternetExplorerDriver(capabilities);
        } else if (browserType.equals("chrome")) {
            return new ChromeDriver(capabilities);
        } else {
            throw new UnrecognizedBrowser(browserType);
        }
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                closeDriver();
            }
        });
    }
}
