package tat.bsu.homework.lesson3.task9;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains list of information about the files,
 * supports adding information of file to list,
 * and receiving a list of information about the files.
 *
 * @author Eugeny Titenkov
 */
public class HtmlTableRowStorage {
    private List<FileInformation> htmlTableRows = new ArrayList<FileInformation>();

    /**
     * Adding information of file to list.
     *
     * @param fileInformation - contains information of file.
     * @return this.
     */
    public HtmlTableRowStorage addFileInformation(FileInformation fileInformation) {
        htmlTableRows.add(fileInformation);
        return this;
    }

    /**
     * Return list of information about the files.
     *
     * @return list of information about the files.
     */
    public List<FileInformation> getFileStorage() {
        return htmlTableRows;
    }

}
