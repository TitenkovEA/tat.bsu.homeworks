package com.tat.myFinalProject.testLoginPage;

import com.tat.myFinalProject.exceptions.IncorrectPageAddress;
import com.tat.myFinalProject.pageObjects.LoginPage;
import com.tat.myFinalProject.pageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest {
    private WebDriver webdriver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws Exception {
        webdriver = new ChromeDriver();
        webdriver.get("http://localhost:8888/wp-login.php");
        loginPage = PageFactory.initElements(webdriver, LoginPage.class);
    }

    @Test
    public void testOnLoginFieldExist() throws Exception {
        Assert.assertNotNull(loginPage.getLoginField());
    }

    @Test
    public void testOnPasswordFieldExist() throws Exception {
        Assert.assertNotNull(loginPage.getPasswordField());
    }

    @Test
    public void testOnSubmitButtonExist() throws Exception {
        Assert.assertNotNull(loginPage.getSubmitButton());
    }

    @Test
    public void testOnErrorBlockExist() throws Exception {
        Assert.assertNotNull(loginPage.getErrorBlock());
    }

    @Test
    public void testOnLinkToMainPageExist() throws Exception {
        Assert.assertNotNull(loginPage.getLinkToMainPage());
    }

    @Test
    public void positiveTestPageAddress() throws Exception {
        Assert.assertTrue(loginPage.webDriverAddressCheck());
    }

    @Test(dataProvider = "unvalidUrlAddresses", dataProviderClass = LoginPageDataProviders.class)
    public void negativeTestPageAddress(String urlAddress) throws Exception {
        loginPage.getWebDriver().get(urlAddress);
        Assert.assertFalse(loginPage.webDriverAddressCheck());
    }

    @Test(expectedExceptions = IncorrectPageAddress.class)
    public void negativeSetLogin() throws Exception {
        webdriver.get("http://localhost:8888/");
        String login = "login";
        loginPage.setLogin(login);
    }

    @Test(expectedExceptions = IncorrectPageAddress.class)
    public void negativeSetPassword() throws Exception {
        webdriver.get("http://localhost:8888/");
        String password = "password";
        loginPage.setLogin(password);
    }

    @Test
    public void positiveBackToWordPress() throws Exception {
        MainPage mainPage = loginPage.backToWordPress();
        Assert.assertEquals(mainPage.getTitle(), MainPage.TITLE);
    }

    @Test
    public void positiveIsErrorFalse() throws Exception {
        Assert.assertFalse(loginPage.isError());
    }

    @Test
    public void positiveIsErrorTrue() throws Exception {
        loginPage.setLogin("illegal user").clickSubmitButton();
        Assert.assertTrue(loginPage.isError());
    }

    @Test(dataProvider = "validUsersData", dataProviderClass = LoginPageDataProviders.class)
    public void positiveTestLogin(String login, String password) throws Exception {
        loginPage.setLogin(login).setPassword(password).clickSubmitButton();
        Assert.assertFalse(loginPage.webDriverAddressCheck());
    }

    @Test
    public void negativeTestLogin() throws Exception {
        String login = "illegalUser";
        String password = "illegalPassword";
        loginPage.setLogin(login).setPassword(password).clickSubmitButton();
        Assert.assertTrue(loginPage.isError());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webdriver.close();
    }
}