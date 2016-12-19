package com.tat.myFinalProject.pageTests.testInChrome;

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
public class SearchPageTest {
    private static final String SQL_DUMP_PATH =
            "Vagrant_LAMP_WordPress" + File.separator + "wordpress.dump.sql";

    private DBWorker dbWorker;
    private WebDriver webDriver;
    private SearchPage searchPage;

    @BeforeClass
    public void setWebDriver() throws SQLException {
        webDriver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dbWorker = DBWorker.getDBWorker();
        dbWorker.createPost(new Post(
                "content",
                "newPost",
                "open"
        ));
    }

    @BeforeMethod
    public void setUp() throws SQLException {
        webDriver.get("http://localhost:8888/?s=");
        searchPage = PageFactory.initElements(webDriver, SearchPage.class);
    }

    public void mainBlockCheck() throws Exception {
        assertTrue(searchPage.getMainBlock().isDisplayed());
    }

    public void headerCheck() throws Exception {
        assertTrue(searchPage.getHeader().isDisplayed());
    }

    public void searchBlockCheck() throws Exception {
        assertTrue(searchPage.getSearchBlock().isDisplayed());
    }

    public void recentPostsBlockCheck() throws Exception {
        assertTrue(searchPage.getRecentPostsBlock().isDisplayed());
    }

    public void archivesBlockCheck() throws Exception {
        assertTrue(searchPage.getArchivesBlock().isDisplayed());
    }

    public void categoriesBlockCheck() throws Exception {
        assertTrue(searchPage.getCategoriesBlock().isDisplayed());
    }

    public void metaBlockCheck() throws Exception {
        assertTrue(searchPage.getMetaBlock().isDisplayed());
    }

    public void toMainPageTest() throws Exception {
        MainPage mainPage = this.searchPage.toMainPage();
        assertTrue(mainPage.webDriverAddressCheck());
    }

    public void searchPageTest() throws Exception {
        SearchPage searchPage = this.searchPage.executeSearch("");
        assertTrue(searchPage.webDriverAddressCheck());
    }

    public void searchTest() throws Exception {
        SearchPage searchPage = this.searchPage.executeSearch("newPost");
        PostPage postPage = searchPage.getPostPageFromMainBlock("newPost");
        assertTrue(postPage.webDriverAddressCheck());
    }

    public void postPageFromMainBlockByHref() throws Exception {
        PostPage newPostPage = searchPage.getPostPageFromRecentPosts("http://localhost:8888/?p=3");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByText() throws Exception {
        PostPage newPostPage = searchPage.getPostPageFromRecentPosts("newPost");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByHref() throws Exception {
        PostPage newPostPage = searchPage.getPostPageFromRecentPosts("http://localhost:8888/?p=3");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void archivePageTest() throws Exception {
        ArchivePage archivePage = this.searchPage.getArchivePage("December 2016");
        assertTrue(archivePage.webDriverAddressCheck());
    }

    public void categoryPageTest() throws Exception {
        CategoryPage categoryPage = searchPage.getCategoryPage("Uncategorized");
        assertTrue(categoryPage.webDriverAddressCheck());
    }

    @AfterClass
    public void tearDown() throws SQLException {
        webDriver.close();
        DBWorker.getDBWorker().dataImport(SQL_DUMP_PATH);
    }
}