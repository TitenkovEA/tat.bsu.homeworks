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

import static org.testng.Assert.assertTrue;

/**
 * @author Eugeny Titenkov
 */
@Test
public class ArchivePageTest {
    private static final String SQL_DUMP_PATH =
            "Vagrant_LAMP_WordPress" + File.separator + "wordpress.dump.sql";

    private DBWorker dbWorker;
    private WebDriver webDriver;
    private ArchivePage archivePage;

    @BeforeClass
    public void setWebDriver() throws SQLException {
        webDriver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
        dbWorker = DBWorker.getDBWorker();
        dbWorker.createPost(new Post(
                "content",
                "newPost",
                "open"
        ));
    }

    @BeforeMethod
    public void setUp() {
        webDriver.get("http://localhost:8888/?m=201612");
        archivePage = PageFactory.initElements(webDriver, ArchivePage.class);
    }

    public void mainBlockCheck() throws Exception {
        assertTrue(archivePage.getMainBlock().isDisplayed());
    }

    public void headerCheck() throws Exception {
        assertTrue(archivePage.getHeader().isDisplayed());
    }

    public void searchBlockCheck() throws Exception {
        assertTrue(archivePage.getSearchBlock().isDisplayed());
    }

    public void recentPostsBlockCheck() throws Exception {
        assertTrue(archivePage.getRecentPostsBlock().isDisplayed());
    }

    public void archivesBlockCheck() throws Exception {
        assertTrue(archivePage.getArchivesBlock().isDisplayed());
    }

    public void categoriesBlockCheck() throws Exception {
        assertTrue(archivePage.getCategoriesBlock().isDisplayed());
    }

    public void metaBlockCheck() throws Exception {
        assertTrue(archivePage.getMetaBlock().isDisplayed());
    }

    public void toMainPageTest() throws Exception {
        MainPage mainPage = this.archivePage.toMainPage();
        assertTrue(mainPage.webDriverAddressCheck());
    }

    public void searchPageTest() throws Exception {
        SearchPage searchPage = archivePage.executeSearch("");
        assertTrue(searchPage.webDriverAddressCheck());
    }

    public void searchTest() throws Exception {
        SearchPage searchPage = this.archivePage.executeSearch("newPost");
        PostPage postPage = searchPage.getPostPageFromMainBlock("newPost");
        assertTrue(postPage.webDriverAddressCheck());
    }

    public void postPageFromMainBlockByText() throws Exception {
        PostPage newPostPage = archivePage.getPostPageFromMainBlock("newPost");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromMainBlockByHref() throws Exception {
        PostPage newPostPage = archivePage.getPostPageFromRecentPosts("http://localhost:8888/?p=3");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByText() throws Exception {
        PostPage newPostPage = archivePage.getPostPageFromRecentPosts("newPost");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByHref() throws Exception {
        PostPage newPostPage = archivePage.getPostPageFromRecentPosts("http://localhost:8888/?p=3");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void archivePageTest() throws Exception {
        ArchivePage archivePage = this.archivePage.getArchivePage("December 2016");
        assertTrue(archivePage.webDriverAddressCheck());
    }

    public void categoryPageTest() throws Exception {
        CategoryPage categoryPage = archivePage.getCategoryPage("Uncategorized");
        assertTrue(categoryPage.webDriverAddressCheck());
    }

    @AfterClass
    public void tearDown() throws SQLException {
        webDriver.close();
        DBWorker.getDBWorker().dataImport(SQL_DUMP_PATH);
    }
}