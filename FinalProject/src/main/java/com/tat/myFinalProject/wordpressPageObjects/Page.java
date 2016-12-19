package com.tat.myFinalProject.wordpressPageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Abstract class representation of a Page in the UI. Page object pattern.
 *
 * @author Titenkov Evgeniy.
 */
public abstract class Page {
    protected WebDriver webDriver;

    /**
     * Constructor injecting the WebDriver interface.
     *
     * @param webDriver - object type of WebDriver.
     */
    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Return title of page.
     *
     * @return tittle.
     */
    public String getTitle() {
        return webDriver.getTitle();
    }

    /**
     * Checks page address with driver address.
     *
     * @return true if address is correct, else false.
     */
    public abstract boolean webDriverAddressCheck();
}
