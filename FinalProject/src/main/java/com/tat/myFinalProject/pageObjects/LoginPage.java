package com.tat.myFinalProject.pageObjects;

import com.tat.myFinalProject.exceptions.IncorrectPageAddress;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 *
 */
public class LoginPage extends Page {
    public static final String TITLE = "WordPress ‹ Log In";

    @FindBy(id = "user_login")
    private WebElement loginField;

    @FindBy(id = "user_pass")
    private WebElement passwordField;

    @FindBy(id = "wp-submit")
    private WebElement submitButton;

    @FindBy(id = "login_error")
    private WebElement errorBlock;

    @FindBy(linkText = "← Back to WordPress")
    private WebElement linkToMainPage;

    /**
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage setLogin(String login) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSubmitButton() {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        submitButton.click();
    }

    public MainPage backToWordPress() {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        linkToMainPage.click();
        return PageFactory.initElements(this.getWebDriver(), MainPage.class);
    }

    public boolean webDriverAddressCheck() {
        return this.getTitle().equals(TITLE);
    }

    public boolean isError() {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        try {
            return errorBlock.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getErrorBlock() {
        return errorBlock;
    }

    public WebElement getLinkToMainPage() {
        return linkToMainPage;
    }
}
