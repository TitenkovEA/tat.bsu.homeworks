package com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages;

import com.tat.myFinalProject.exceptions.IncorrectPageAddress;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.PostPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.WordPressPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Evgeniy Titenkov.
 */
public abstract class HomePage extends WordPressPage {
    /**
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage getPostPageFromMainBlock(String linkTextOrHref) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        if (linkTextOrHref.matches("http://.+")) {
            String cssSelector = "a[href='" + linkTextOrHref + "']";
            mainBlock.findElement(By.cssSelector(cssSelector)).click();
        } else {
            mainBlock.findElement(By.linkText(linkTextOrHref)).click();
        }
        return PageFactory.initElements(this.getWebDriver(), PostPage.class);
    }
}
