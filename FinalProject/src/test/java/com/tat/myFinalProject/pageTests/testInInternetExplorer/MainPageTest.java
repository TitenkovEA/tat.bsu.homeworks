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
public class MainPageTest {
    private static final String SQL_DUMP_PATH =
            "Vagrant_LAMP_WordPress" + File.separator + "wordpress.dump.sql";

    private DBWorker dbWorker;
    private WebDriver webDriver;
    private MainPage mainPage;

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
        webDriver.get("http://localhost:8888/");
        mainPage = PageFactory.initElements(webDriver, MainPage.class);
    }

    public void mainBlockCheck() throws Exception {
        assertTrue(mainPage.getMainBlock().isDisplayed());
    }

    public void headerCheck() throws Exception {
        assertTrue(mainPage.getHeader().isDisplayed());
    }

    public void searchBlockCheck() throws Exception {
        assertTrue(mainPage.getSearchBlock().isDisplayed());
    }

    public void recentPostsBlockCheck() throws Exception {
        assertTrue(mainPage.getRecentPostsBlock().isDisplayed());
    }

    public void archivesBlockCheck() throws Exception {
        assertTrue(mainPage.getArchivesBlock().isDisplayed());
    }

    public void categoriesBlockCheck() throws Exception {
        assertTrue(mainPage.getCategoriesBlock().isDisplayed());
    }

    public void metaBlockCheck() throws Exception {
        assertTrue(mainPage.getMetaBlock().isDisplayed());
    }

    public void toMainPageTest() throws Exception {
        MainPage mainPage = this.mainPage.toMainPage();
        assertTrue(mainPage.webDriverAddressCheck());
    }

    public void searchPageTest() throws Exception {
        SearchPage searchPage = mainPage.executeSearch("");
        assertTrue(searchPage.webDriverAddressCheck());
    }

    public void searchTest() throws Exception {
        SearchPage searchPage = mainPage.executeSearch("newPost");
        PostPage postPage = searchPage.getPostPageFromMainBlock("newPost");
        assertTrue(postPage.webDriverAddressCheck());
    }

    public void postPageFromMainBlockByText() throws Exception {
        PostPage newPostPage = mainPage.getPostPageFromMainBlock("newPost");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromMainBlockByHref() throws Exception {
        PostPage newPostPage = mainPage.getPostPageFromRecentPosts("http://localhost:8888/?p=3");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByText() throws Exception {
        PostPage newPostPage = mainPage.getPostPageFromRecentPosts("newPost");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByHref() throws Exception {
        PostPage newPostPage = mainPage.getPostPageFromRecentPosts("http://localhost:8888/?p=3");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void archivePageTest() throws Exception {
        ArchivePage archivePage = mainPage.getArchivePage("December 2016");
        assertTrue(archivePage.webDriverAddressCheck());
    }

    public void categoryPageTest() throws Exception {
        CategoryPage categoryPage = mainPage.getCategoryPage("Uncategorized");
        assertTrue(categoryPage.webDriverAddressCheck());
    }

    @AfterClass
    public void tearDown() throws SQLException {
        webDriver.close();
        DBWorker.getDBWorker().dataImport(SQL_DUMP_PATH);
    }
}