package com.tat.myFinalProject.entity;

/**
 * Some simple entity of User object.
 *
 * @author Evgeny Titenkov.
 */
public class User {
    private String id;
    private String login;
    private String email;
    private String password;
    private String capabilities;

    /**
     * Simple constructor of User, which contains short information of user.
     *
     * @param id    - user id.
     * @param login - user login.
     * @param email - user email.
     */
    public User(String id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    /**
     * Constructor to add a User to database.
     *
     * @param id           - user id.
     * @param login        - user login.
     * @param email        - user email.
     * @param password     - user password.
     * @param capabilities - user capabilities.
     */
    public User(String id, String login, String email, String password, String capabilities) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.capabilities = capabilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        int result = getLogin().hashCode();
        result = 31 * result + getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }

    /**
     * Return user password.
     *
     * @return user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return user password.
     *
     * @return user password.
     */
    public String getCapabilities() {
        return capabilities;
    }

    /**
     * Return user password.
     *
     * @return user password.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Return user password.
     *
     * @return user password.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Return user password.
     *
     * @return user password.
     */
    public String getId() {
        return id;
    }
}
