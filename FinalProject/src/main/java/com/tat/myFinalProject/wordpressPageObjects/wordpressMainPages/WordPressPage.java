package com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages;

import com.tat.myFinalProject.exceptions.IncorrectPageAddress;
import com.tat.myFinalProject.wordpressPageObjects.*;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.ArchivePage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.CategoryPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.MainPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class WordPressPage extends Page {
    @FindBy(id = "masthead")
    private WebElement header;

    @FindBy(id = "main")
    protected WebElement mainBlock;

    @FindBy(id = "search-2")
    private WebElement searchBlock;

    @FindBy(id = "recent-posts-2")
    private WebElement recentPostsBlock;

    @FindBy(id = "archives-2")
    private WebElement archivesBlock;

    @FindBy(id = "categories-2")
    private WebElement categoriesBlock;

    @FindBy(id = "meta-2")
    private WebElement metaBlock;

    /**
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public WordPressPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage toMainPage() {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        header.findElement(By.linkText("WordPress")).click();
        return PageFactory.initElements(this.getWebDriver(), MainPage.class);
    }

    public SearchPage executeSearch(String searchTarget) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        searchBlock.findElement(By.cssSelector(".search-field")).sendKeys(searchTarget);
        searchBlock.findElement(By.cssSelector(".search-submit")).click();
        return PageFactory.initElements(this.getWebDriver(), SearchPage.class);
    }

    public PostPage getPostPageFromRecentPosts(String linkTextOrHref) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        if (linkTextOrHref.matches("http://.+")) {
            String cssSelector = "a[href='" + linkTextOrHref + "']";
            recentPostsBlock.findElement(By.cssSelector(cssSelector)).click();
        } else {
            recentPostsBlock.findElement(By.linkText(linkTextOrHref)).click();
        }
        return PageFactory.initElements(this.getWebDriver(), PostPage.class);
    }

    public ArchivePage getArchivePage(String linkText) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        WebElement link = archivesBlock.findElement(By.linkText(linkText));
        String newUrl = link.getAttribute("href");
        this.getWebDriver().get(newUrl);
        return PageFactory.initElements(this.getWebDriver(), ArchivePage.class);
    }

    public CategoryPage getCategoryPage(String linkText) {
        if (!webDriverAddressCheck()) {
            throw new IncorrectPageAddress();
        }
        WebElement link = categoriesBlock.findElement(By.linkText(linkText));
        String newUrl = link.getAttribute("href");
        this.getWebDriver().get(newUrl);
        return PageFactory.initElements(this.getWebDriver(), CategoryPage.class);
    }

    public WebElement getHeader() {
        return header;
    }

    public WebElement getMainBlock() {
        return mainBlock;
    }

    public WebElement getSearchBlock() {
        return searchBlock;
    }

    public WebElement getRecentPostsBlock() {
        return recentPostsBlock;
    }

    public WebElement getArchivesBlock() {
        return archivesBlock;
    }

    public WebElement getCategoriesBlock() {
        return categoriesBlock;
    }

    public WebElement getMetaBlock() {
        return metaBlock;
    }
}
