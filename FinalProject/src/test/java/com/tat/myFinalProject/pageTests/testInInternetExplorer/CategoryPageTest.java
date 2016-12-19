package com.tat.myFinalProject.pageTests.testInInternetExplorer;

import com.tat.myFinalProject.entity.Post;
import com.tat.myFinalProject.utils.databaseUtils.DBWorker;
import com.tat.myFinalProject.factories.WebDriverFactory;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.PostPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.ArchivePage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.CategoryPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.MainPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * @author Eugeny Titenkov
 */
@Test
public class CategoryPageTest {
    private static final String SQL_DUMP_PATH =
            "Vagrant_LAMP_WordPress" + File.separator + "wordpress.dump.sql";

    private DBWorker dbWorker;
    private WebDriver webDriver;
    private CategoryPage categoryPage;

    @BeforeClass
    public void setWebDriver() throws SQLException {
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("ignoreZoomSetting", true);
        webDriver = WebDriverFactory.getDriver(caps);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dbWorker = DBWorker.getDBWorker();
        dbWorker.createPost(new Post(
                "content",
                "newPost",
                "open"
        ));
    }

    @BeforeMethod
    public void setUp() {
        webDriver.get("http://localhost:8888/?cat=1");
        categoryPage = PageFactory.initElements(webDriver, CategoryPage.class);
    }

    public void mainBlockCheck() throws Exception {
        assertTrue(categoryPage.getMainBlock().isDisplayed());
    }

    public void headerCheck() throws Exception {
        assertTrue(categoryPage.getHeader().isDisplayed());
    }

    public void searchBlockCheck() throws Exception {
        assertTrue(categoryPage.getSearchBlock().isDisplayed());
    }

    public void recentPostsBlockCheck() throws Exception {
        assertTrue(categoryPage.getRecentPostsBlock().isDisplayed());
    }

    public void archivesBlockCheck() throws Exception {
        assertTrue(categoryPage.getArchivesBlock().isDisplayed());
    }

    public void categoriesBlockCheck() throws Exception {
        assertTrue(categoryPage.getCategoriesBlock().isDisplayed());
    }

    public void metaBlockCheck() throws Exception {
        assertTrue(categoryPage.getMetaBlock().isDisplayed());
    }

    public void toMainPageTest() throws Exception {
        MainPage mainPage = this.categoryPage.toMainPage();
        assertTrue(mainPage.webDriverAddressCheck());
    }

    public void searchPageTest() throws Exception {
        SearchPage searchPage = this.categoryPage.executeSearch("");
        assertTrue(searchPage.webDriverAddressCheck());
    }

    public void searchTest() throws Exception {
        SearchPage searchPage = this.categoryPage.executeSearch("newPost");
        PostPage postPage = searchPage.getPostPageFromMainBlock("newPost");
        assertTrue(postPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByText() throws Exception {
        PostPage newPostPage = categoryPage.getPostPageFromRecentPosts("Hello world!");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByHref() throws Exception {
        PostPage newPostPage = categoryPage.getPostPageFromRecentPosts("http://localhost:8888/?p=1");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void archivePageTest() throws Exception {
        ArchivePage archivePage = this.categoryPage.getArchivePage("December 2016");
        assertTrue(archivePage.webDriverAddressCheck());
    }

    public void categoryPageTest() throws Exception {
        CategoryPage categoryPage = this.categoryPage.getCategoryPage("Uncategorized");
        assertTrue(categoryPage.webDriverAddressCheck());
    }

    @AfterClass
    public void tearDown() throws SQLException {
        webDriver.close();
        DBWorker.getDBWorker().dataImport(SQL_DUMP_PATH);
    }
}