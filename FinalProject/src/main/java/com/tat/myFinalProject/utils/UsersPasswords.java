package com.tat.myFinalProject.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains all users passwords.
 *
 * @author Evgeniy Titenkov.
 */
public class UsersPasswords {
    private static Map<String, String> passwords = new HashMap<>();

    private static UsersPasswords usersPasswords;

    private UsersPasswords() {
    }

    /**
     * Returns a DBWorker object, its a Singleton class.
     *
     * @return DBWorker.
     */
    public static UsersPasswords getUserPasswords() {
        if (usersPasswords == null) {
            usersPasswords = new UsersPasswords();
        }
        return usersPasswords;
    }

    /**
     * Adds a user's password to the map, where key is id, and value is password.
     *
     * @param userId   - user id.
     * @param password - user password.
     */
    public void addPassword(String userId, String password) {
        passwords.put(userId, password);
    }

    /**
     * Return password by id.
     *
     * @param id - user id.
     * @return password.
     */
    public String getPassword(String id) {
        return passwords.get(id);
    }

    /*
     * Add to map id and password of admin user.
     */
    static {
        passwords.put("1", "admin");
    }
}
