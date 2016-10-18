package tat.bsu.homework.lesson3.task9;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

/**
 * Contains application entry point.
 *
 * @author Eugeny Titenkov
 */
public class Main {
    private static String CURRENT_PATH = Paths.get("").toAbsolutePath().toString();
    private static final int GENERIC_ERROR = 1;

    /**
     * Creates a list of the current directory files,
     * then fills the html table storage of information about the files,
     * then builds a html table and creates html file with the table.
     *
     * @param args - command line parameters.
     */
    public static void main(String[] args) {
        try {
            File[] files = new File(CURRENT_PATH).listFiles();
            SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
            HtmlTableRowStorage htmlTableRowStorage = new HtmlTableRowStorage();
            for (File file : files) {
                if (file.isFile()) {
                    htmlTableRowStorage.addFileInformation(new FileInformation(file.getName(), "FILE",
                            sdf.format(file.lastModified()), byteToKilobyte(file.length())));
                }
                if (file.isDirectory()) {
                    htmlTableRowStorage.addFileInformation(new FileInformation(file.getName(), "DIR",
                            sdf.format(file.lastModified()), byteToKilobyte(folderSize(file))));
                }
            }
            String htmlTable = new HtmlTableBuilder().buildHtmlTable(htmlTableRowStorage);
            File file = new File(CURRENT_PATH + File.separator + "Table.html");
            PrintWriter writer = new PrintWriter(file);
            writer.print(htmlTable);
            writer.close();
        } catch (Exception e) {
            System.err.println("Unrecognized error: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }

    /**
     * Calculate the total size of directory.
     *
     * @param directory - directory file
     * @return length type of long.
     */
    private static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                length += file.length();
            }
            if (file.isDirectory()) {
                length += folderSize(file);
            }
        }
        return length;
    }

    /**
     * Converts byte to kilobyte.
     *
     * @param byteSize - size in bytes.
     * @return size in kilobytes type of long.
     */
    private static long byteToKilobyte(long byteSize) {
        long size = byteSize / 1024;
        if (byteSize > 0 && size == 0) {
            return 1;
        }
        return size;
    }
}
