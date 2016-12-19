package com.tat.myFinalProject.dataProviders;

import com.tat.myFinalProject.entity.User;
import com.tat.myFinalProject.utils.UsersPasswords;
import com.tat.myFinalProject.utils.databaseUtils.DBWorker;
import org.testng.annotations.DataProvider;

import java.sql.SQLException;
import java.util.List;

public class DataProviders {
    private static DBWorker dbWorker = DBWorker.getDBWorker();

    @DataProvider(name = "invalidUrlAddresses")
    public static Object[][] createInvalidUrlAddresses() throws Exception {
        Object[][] result = new Object[][]{
                {"http://localhost:8888/"},
                {"https://www.google.ru/"},
        };
        return result;
    }

    @DataProvider(name = "validUsersData")
    public static Object[][] createValidUsersToLoginTest() throws Exception {
        addUsersToDB();
        UsersPasswords usersPasswords = UsersPasswords.getUserPasswords();
        List<User> users = dbWorker.getUsers();
        Object[][] result = new Object[users.size() * 2][2];
        int index = 0;
        for (User user : users) {
            result[index][0] = user.getLogin();
            result[index][1] = usersPasswords.getPassword(user.getId());
            index++;
            result[index][0] = user.getEmail();
            result[index][1] = usersPasswords.getPassword(user.getId());
            index++;
        }
        return result;
    }

    private static void addUsersToDB() throws SQLException {
        UsersPasswords usersPasswords = UsersPasswords.getUserPasswords();

        dbWorker.createUser(new User(
                "2",
                "subscriber",
                "subscriber@mail.ru",
                "subscriber",
                "a:1:{s:10:\"subscriber\";b:1;}"
        ));
        usersPasswords.addPassword("2", "subscriber");

        dbWorker.createUser(new User(
                "3",
                "Contributor",
                "Contributor@mail.ru",
                "Contributor",
                "a:1:{s:11:\"contributor\";b:1;}"));
        usersPasswords.addPassword("3", "Contributor");

        dbWorker.createUser(new User(
                "4",
                "author",
                "author@mail.ru",
                "author",
                "a:1:{s:6:\"author\";b:1;}"
        ));
        usersPasswords.addPassword("4", "author");

        dbWorker.createUser(new User(
                "5",
                "editor",
                "editor@mail.ru",
                "editor",
                "a:1:{s:6:\"editor\";b:1;}"
        ));
        usersPasswords.addPassword("5", "editor");
    }
}
