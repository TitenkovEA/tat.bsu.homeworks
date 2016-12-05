package com.tat.myFinalProject.testLoginPage;

import org.testng.annotations.DataProvider;

public class LoginPageDataProviders {
    @DataProvider(name = "unvalidUrlAddresses")
    public static Object[][] createUnvalidUrlAddresses() throws Exception {
        Object[][] result = new Object[][]{
                {"http://localhost:8888/"},
                {"https://www.google.ru/"},
        };
        return result;
    }

    @DataProvider(name = "validUsersData")
    public static Object[][] createValidUsersData() throws Exception {
        Object[][] result = new Object[][]{
                {"admin", "admin"},
                {"admin@mail.ru", "admin"}
        };
        return result;
    }
}
