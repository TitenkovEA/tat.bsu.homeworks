package tat.bsu.homework.lesson3.task9;

/**
 * Contains information about file.
 *
 * @author Eugeny Titenkov
 */
public class FileInformation {
    private String name;
    private String type;
    private String date;
    private long size;

    /**
     * Creates object of FileInformation, gets input parameters of FileInformation
     * and adds information about input types of FileInformation.
     *
     * @param name - name of file.
     * @param type - type of file.
     * @param date - date of last modification.
     * @param size - size of file.
     */
    public FileInformation(String name, String type, String date, long size) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.size = size;
    }

    /**
     * Return name of file.
     *
     * @return name of file.
     */
    public String getName() {
        return name;
    }

    /**
     * Return type of file.
     *
     * @return type of file.
     */
    public String getType() {
        return type;
    }

    /**
     * Return date of last modification.
     *
     * @return date of last modification.
     */
    public String getDate() {
        return date;
    }

    /**
     * Return size of file.
     *
     * @return size of file.
     */
    public long getSize() {
        return size;
    }
}
