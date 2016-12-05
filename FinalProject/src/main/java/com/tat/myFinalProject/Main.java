package com.tat.myFinalProject;

import com.tat.myFinalProject.pageObjects.LoginPage;
import com.tat.myFinalProject.pageObjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Я on 05.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8888/wp-login.php");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        if (loginPage.getTitle().equals(LoginPage.TITLE)) {
            System.out.println(loginPage.webDriverAddressCheck());
            loginPage.clickSubmitButton();
            System.out.println(loginPage.isError());
        }
        driver.close();
    }
}
