package com.tat.myFinalProject.pageObjects;

import org.openqa.selenium.WebDriver;

/**
 *
 */
public class MainPage extends Page {
    public static final String TITLE = "WordPress – Just another WordPress site";

    /**
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
}
