package com.tat.myFinalProject.entity;

/**
 * Some simple entity of post object.
 *
 * @author Evgeny Titenkov.
 */
public class Post {
    private String content;
    private String title;
    private String status;
    private String id;

    /**
     * Constructor to add a post to database.
     *
     * @param content - post content.
     * @param title   - post title
     * @param status  - post comment status("open" or "close")
     */
    public Post(String content, String title, String status) {
        this.content = content;
        this.title = title;
        this.status = status;
    }

    /**
     * Simple constructor of a post, contains title and id of post.
     *
     * @param title - post title.
     * @param id    - post id.
     */
    public Post(String title, String id) {
        this.title = title;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (!getContent().equals(post.getContent())) return false;
        if (!getTitle().equals(post.getTitle())) return false;
        if (!getStatus().equals(post.getStatus())) return false;
        return getId().equals(post.getId());
    }

    @Override
    public int hashCode() {
        int result = getContent().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getId().hashCode();
        return result;
    }

    /**
     * Return content of a post.
     *
     * @return content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Return title of a post.
     *
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return status of a post.
     *
     * @return status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Return id of a post.
     *
     * @return id.
     */
    public String getId() {
        return id;
    }
}
