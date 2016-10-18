package tat.bsu.homework.lesson3.task10;

import java.io.*;
import java.nio.file.Paths;

/**
 * Contains application entry point.
 *
 * @author Eugeny Titenkov
 */
public class Main {
    private static String CURRENT_PATH = Paths.get("").toAbsolutePath().toString();
    private static final int GENERIC_ERROR = 1;
    private static final String WRONG_IP = "Detected wrong ip address";
    private static final String FILE_READ_ERROR = "File read error!";
    private static final String WRITE_FILE_ERROR = "Write file error!";
    private static final String INPUT_FILE = "IpAddresses.txt";
    private static final String OUTPUT_FILE = "Table.html";

    /**
     * Reads the ip address from command line if, command line is empty, then from file,
     * where the file should be named "IpAddresses.txt", and be in the directory of program start,
     * then fills the html table storage depending on ip addresses,
     * and then builds a html table and creates html file with the table.
     *
     * @param args - command line parameters.
     */
    public static void main(String[] args) {
        try {
            String[] ipAddresses;
            HtmlTableRowStorage htmlTableRowStorage = new HtmlTableRowStorage();
            if (args.length > 0) {
                ipAddresses = args;
                if (Validator.validateIpAddresses(ipAddresses)) {
                    htmlTableRowStorage = fillHtmlTableRowStorage(ipAddresses);
                } else {
                    System.err.println(WRONG_IP);
                }
            } else {
                ipAddresses = readFile();
                if (Validator.validateIpAddresses(ipAddresses)) {
                    htmlTableRowStorage = fillHtmlTableRowStorage(ipAddresses);
                }
            }
            String htmlTable = new HtmlTableBuilder().buildHtmlTable(htmlTableRowStorage);
            createHtmlTableFile(htmlTable);
        } catch (Exception e) {
            System.err.println("Unrecognized error: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }

    /**
     * Read file with ip addresses, and convert they to String array.
     *
     * @return String array with ip addresses.
     */
    private static String[] readFile() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println(FILE_READ_ERROR);
        }
        return stringBuilder.toString().split(System.lineSeparator());
    }

    /**
     * Fills the html table storage depending on ip addresses
     *
     * @param ipAddresses addresses to fill.
     * @return HtmlTableRowStorage.
     */
    private static HtmlTableRowStorage fillHtmlTableRowStorage(String[] ipAddresses) {
        HtmlTableRowStorage htmlTableRowStorage = new HtmlTableRowStorage();
        for (String ipAddress : ipAddresses) {
            htmlTableRowStorage.addHtmlTableRow(new HtmlServerEntryRow(ipAddress));
        }
        return htmlTableRowStorage;
    }

    /**
     * Creates html file with the table.
     *
     * @param htmlTable html table in string.
     */
    private static void createHtmlTableFile(String htmlTable) {
        File file = new File(CURRENT_PATH + File.separator + OUTPUT_FILE);
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print(htmlTable);
            writer.close();
        } catch (IOException e) {
            System.err.println(WRITE_FILE_ERROR);
        }
    }
}
