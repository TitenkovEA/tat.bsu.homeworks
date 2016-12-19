package com.tat.myFinalProject.pageTests.testInChrome;

import com.tat.myFinalProject.entity.Post;
import com.tat.myFinalProject.utils.databaseUtils.DBWorker;
import com.tat.myFinalProject.factories.WebDriverFactory;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.PostPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.ArchivePage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.CategoryPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.MainPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.SQLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Eugeny Titenkov
 */
@Test
public class PostPageTest {
    private static final String SQL_DUMP_PATH =
            "Vagrant_LAMP_WordPress" + File.separator + "wordpress.dump.sql";

    private DBWorker dbWorker;
    private WebDriver webDriver;
    private PostPage postPage;

    @BeforeClass
    public void setWebDriver() throws SQLException {
        webDriver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
        dbWorker = DBWorker.getDBWorker();
        dbWorker.createPost(new Post(
                "content",
                "newPost",
                "open"
        ));
        dbWorker.createPost(new Post(
                "content with closed comments",
                "Post with closed comment",
                "close"
        ));
    }

    @BeforeMethod
    public void setUp() {
        webDriver.get("http://localhost:8888/?p=1");
        postPage = PageFactory.initElements(webDriver, PostPage.class);
    }

    public void mainBlockCheck() throws Exception {
        assertTrue(postPage.getMainBlock().isDisplayed());
    }

    public void headerCheck() throws Exception {
        assertTrue(postPage.getHeader().isDisplayed());
    }

    public void searchBlockCheck() throws Exception {
        assertTrue(postPage.getSearchBlock().isDisplayed());
    }

    public void recentPostsBlockCheck() throws Exception {
        assertTrue(postPage.getRecentPostsBlock().isDisplayed());
    }

    public void archivesBlockCheck() throws Exception {
        assertTrue(postPage.getArchivesBlock().isDisplayed());
    }

    public void categoriesBlockCheck() throws Exception {
        assertTrue(postPage.getCategoriesBlock().isDisplayed());
    }

    public void metaBlockCheck() throws Exception {
        assertTrue(postPage.getMetaBlock().isDisplayed());
    }

    public void commentsBlockCheck() throws Exception {
        assertTrue(postPage.getCommentsBlock().isDisplayed());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void commentsBlockCheckOnPostWithClosedComment() throws Exception {
        webDriver.get("http://localhost:8888/?p=4");
        postPage = PageFactory.initElements(webDriver, PostPage.class);
        postPage.getCommentsBlock().getLocation();
    }

    public void commentAuthorCheck() throws Exception {
        assertTrue(postPage.getCommentAuthor().isDisplayed());
    }

    public void commentAuthorEmailCheck() throws Exception {
        assertTrue(postPage.getCommentAuthorEmail().isDisplayed());
    }

    public void commentTextAreaCheck() throws Exception {
        assertTrue(postPage.getCommentTextArea().isDisplayed());
    }

    public void submitCommentButtonCheck() throws Exception {
        assertTrue(postPage.getSubmitCommentButton().isDisplayed());
    }

    public void toMainPageTest() throws Exception {
        MainPage mainPage = postPage.toMainPage();
        assertTrue(mainPage.webDriverAddressCheck());
    }

    public void searchPageTest() throws Exception {
        SearchPage searchPage = postPage.executeSearch("");
        assertTrue(searchPage.webDriverAddressCheck());
    }

    public void searchTest() throws Exception {
        SearchPage searchPage = postPage.executeSearch("newPost");
        PostPage postPage = searchPage.getPostPageFromMainBlock("newPost");
        assertTrue(postPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByText() throws Exception {
        PostPage newPostPage = postPage.getPostPageFromRecentPosts("newPost");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void postPageFromResentPostByHref() throws Exception {
        PostPage newPostPage = postPage.getPostPageFromRecentPosts("http://localhost:8888/?p=3");
        assertTrue(newPostPage.webDriverAddressCheck());
    }

    public void archivePageTest() throws Exception {
        ArchivePage archivePage = postPage.getArchivePage("December 2016");
        assertTrue(archivePage.webDriverAddressCheck());
    }

    public void categoryPageTest() throws Exception {
        CategoryPage categoryPage = postPage.getCategoryPage("Uncategorized");
        assertTrue(categoryPage.webDriverAddressCheck());
    }

    public void liveCommentTest() throws Exception {
        webDriver.get("http://localhost:8888/?p=3");
        postPage.setAuthor("testAuthor").setEmail("test@mail.ru").setComment("testComment").submitComment();
        String commentText = postPage.getCommentsBlock().findElement(By.cssSelector("div > p")).getText();
        assertEquals(commentText, "testComment");
    }

    public void liveReplyTest() throws Exception {
        postPage.replyComment("http://localhost:8888/?p=1&replytocom=1#respond");
        postPage.setAuthor("testAuthor2");
        postPage.setEmail("test2@mail.ru");
        postPage.setComment("testComment2");
        postPage.submitComment();
        WebElement firstCommentBlock = postPage.getCommentsBlock().findElement(By.id("div-comment-2"));
        String commentText = firstCommentBlock.findElement(By.cssSelector("div > p")).getText();
        assertEquals(commentText, "testComment2");
    }

    public void testPostContentWithOpenComment() throws Exception {
        webDriver.get("http://localhost:8888/?p=3");
        String actual = postPage.getMainBlock().findElement(By.cssSelector("div > p")).getText();
        String expected = "content";
        assertEquals(actual, expected);
    }

    public void testPostContentWithClosedComment() throws Exception {
        webDriver.get("http://localhost:8888/?p=4");
        String actual = postPage.getMainBlock().findElement(By.cssSelector("div > p")).getText();
        String expected = "content with closed comments";
        assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() throws SQLException {
        webDriver.close();
        DBWorker.getDBWorker().dataImport(SQL_DUMP_PATH);
    }
}