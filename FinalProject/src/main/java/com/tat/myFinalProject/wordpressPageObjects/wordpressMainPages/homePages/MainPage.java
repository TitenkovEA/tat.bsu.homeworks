package com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class MainPage extends HomePage {
    public static final String TITLE = "WordPress – Just another WordPress site";

    @FindBy(id = "main")
    private WebElement postsBlock;

    /**
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean webDriverAddressCheck() {
        return this.getTitle().equals(TITLE);
    }


}
