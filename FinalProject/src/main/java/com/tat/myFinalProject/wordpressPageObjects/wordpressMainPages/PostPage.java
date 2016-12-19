package com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages;

import com.tat.myFinalProject.exceptions.IncorrectPageAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Evgeniy Titenkov.
 */
public class PostPage extends WordPressPage {
    private static final String URL_REGEX = "http://localhost:8888/\\?p=.+";

    @FindBy(id = "comments")
    private WebElement commentsBlock;

    @FindBy(id = "comment")
    private WebElement commentTextArea;

    @FindBy(id = "author")
    private WebElement commentAuthor;

    @FindBy(id = "email")
    private WebElement commentAuthorEmail;

    @FindBy(id = "submit")
    private WebElement submitCommentButton;

    /**
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean webDriverAddressCheck() {
        return this.getWebDriver().getCurrentUrl().matches(URL_REGEX);
    }

    public void replyComment(String href) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        String cssSelector = "a[href='" + href + "']";
        commentsBlock.findElement(By.cssSelector(cssSelector)).click();
    }

    public PostPage setComment(String comment) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        commentTextArea.clear();
        commentTextArea.sendKeys(comment);
        return this;
    }

    public PostPage setAuthor(String author) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        commentAuthor.clear();
        commentAuthor.sendKeys(author);
        return this;
    }

    public PostPage setEmail(String email) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        commentAuthorEmail.clear();
        commentAuthorEmail.sendKeys(email);
        return this;
    }

    public void submitComment() {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        submitCommentButton.click();
    }

    public WebElement getCommentsBlock() {
        return commentsBlock;
    }

    public WebElement getCommentTextArea() {
        return commentTextArea;
    }

    public WebElement getCommentAuthor() {
        return commentAuthor;
    }

    public WebElement getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public WebElement getSubmitCommentButton() {
        return submitCommentButton;
    }
}
