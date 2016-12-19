package com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages;

import org.openqa.selenium.WebDriver;

/**
 * @author Evgeniy Titenkov.
 */
public class CategoryPage extends HomePage {
    private static final String URL_REGEX = "http://localhost:8888/\\?cat=.+";

    /**
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean webDriverAddressCheck() {
        return this.getWebDriver().getCurrentUrl().matches(URL_REGEX);
    }
}
