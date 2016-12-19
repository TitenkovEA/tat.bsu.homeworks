package com.tat.myFinalProject.pageTests.testInChrome;

import com.tat.myFinalProject.dataProviders.DataProviders;
import com.tat.myFinalProject.utils.databaseUtils.DBWorker;
import com.tat.myFinalProject.exceptions.IncorrectPageAddress;
import com.tat.myFinalProject.factories.WebDriverFactory;
import com.tat.myFinalProject.wordpressPageObjects.LoginPage;
import com.tat.myFinalProject.wordpressPageObjects.wordpressMainPages.homePages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Test
public class LoginPageTest {
    private static final String SQL_DUMP_PATH =
            "Vagrant_LAMP_WordPress" + File.separator + "wordpress.dump.sql";

    private WebDriver webDriver;
    private LoginPage loginPage;
    private DBWorker dbWorker;

    @BeforeClass
    public void setWebDriver() throws Exception {
        webDriver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dbWorker = DBWorker.getDBWorker();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        webDriver.get("http://localhost:8888/wp-login.php");
        loginPage = PageFactory.initElements(webDriver, LoginPage.class);
    }

    public void testOnLoginFieldExist() throws Exception {
        Assert.assertTrue(loginPage.getLoginField().isDisplayed());
    }

    public void testOnPasswordFieldExist() throws Exception {
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
    }

    public void testOnSubmitButtonExist() throws Exception {
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }

    public void testOnLinkToMainPageExist() throws Exception {
        Assert.assertTrue(loginPage.getLinkToMainPage().isDisplayed());
    }

    public void positiveTestPageAddress() throws Exception {
        Assert.assertTrue(loginPage.webDriverAddressCheck());
    }

    @Test(dataProvider = "createInvalidUrlAddresses",
            dataProviderClass = DataProviders.class)
    public void negativeTestPageAddress(String urlAddress) throws Exception {
        loginPage.getWebDriver().get(urlAddress);
        Assert.assertFalse(loginPage.webDriverAddressCheck());
    }

    @Test(expectedExceptions = IncorrectPageAddress.class)
    public void negativeSetLogin() throws Exception {
        webDriver.get("http://localhost:8888/");
        String login = "login";
        loginPage.setLogin(login);
    }

    @Test(expectedExceptions = IncorrectPageAddress.class)
    public void negativeSetPassword() throws Exception {
        webDriver.get("http://localhost:8888/");
        String password = "password";
        loginPage.setLogin(password);
    }

    public void positiveBackToWordPress() throws Exception {
        MainPage mainPage = loginPage.backToWordPress();
        Assert.assertTrue(mainPage.webDriverAddressCheck());
    }

    public void positiveIsErrorFalse() throws Exception {
        Assert.assertFalse(loginPage.isError());
    }

    public void positiveIsErrorTrue() throws Exception {
        loginPage.setLogin("illegal user").clickSubmitButton();
        Assert.assertTrue(loginPage.isError());
    }

    @Test(dataProvider = "validUsersData", dataProviderClass = DataProviders.class)
    public void positiveTestLogin(String login, String password) throws Exception {
        loginPage.setLogin(login);
        Thread.sleep(100);
        loginPage.setPassword(password).clickSubmitButton();
        Assert.assertTrue(loginPage.getWebDriver().getCurrentUrl().startsWith(
                "http://localhost:8888/wp-admin"));
    }

    public void negativeTestLogin() throws Exception {
        String login = "illegalUser";
        String password = "illegalPassword";
        loginPage.setLogin(login).setPassword(password).clickSubmitButton();
        Assert.assertTrue(loginPage.isError());
    }

    @AfterClass
    public void tearDown() throws Exception {
        dbWorker.dataImport(SQL_DUMP_PATH);
        webDriver.close();
    }
}