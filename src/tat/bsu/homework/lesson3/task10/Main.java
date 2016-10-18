package tat.bsu.homework.lesson3.task10;

import java.io.*;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/**
 * Contains application entry point.
 *
 * @author Eugeny Titenkov
 */
public class Main {
    private static String CURRENT_PATH = Paths.get("").toAbsolutePath().toString();
    private static final int GENERIC_ERROR = 1;
    private static final String START_PROGRAM = "Select the data source. \n" +
            "If it's command line, enter: [command line]. \n" +
            "If it's file(ipAddresses), enter: [file]. \n";
    private static final String ANSWER_IS_COMMAND_LINE = "command line";
    private static final String ANSWER_IS_FILE = "file";
    private static final String WRONG_IP = "Detected wrong ip address";
    private static final String WRONG_DATA_SOURCE = "Wrong data source";
    private static final String FILE_READ_ERROR = "File read error!";

    /**
     * Reads the ip address of your choosing from command line or from file,
     * where the file should be named "IpAddresses.txt", and be in the directory of program start,
     * then fills the html table storage depending on ip addresses,
     * and then builds a html table and creates html file with the table.
     *
     * @param args - command line parameters.
     * @throws IOException for PrintWriter,
     *                     some of its constructors may throw I/O exceptions.
     */
    public static void main(String[] args) throws IOException {
        try {
            String[] ipAddresses;
            HtmlTableRowStorage htmlTableRowStorage = new HtmlTableRowStorage();
            Scanner scanner = new Scanner(System.in);
            System.out.print(START_PROGRAM);
            String answer = scanner.nextLine();
            scanner.close();
            if (answer.equals(ANSWER_IS_COMMAND_LINE)) {
                ipAddresses = args;
                if (Validator.validateIpAddresses(ipAddresses)) {
                    for (String ipAddress : ipAddresses) {
                        htmlTableRowStorage.addHtmlTableRow(new HtmlTableRow(ipAddress,
                                generateMs()));
                    }
                } else {
                    System.err.println(WRONG_IP);
                }
            } else if (answer.equals(ANSWER_IS_FILE)) {
                ipAddresses = readFile();
                if (Validator.validateIpAddresses(ipAddresses)) {
                    for (String ipAddress : ipAddresses) {
                        htmlTableRowStorage.addHtmlTableRow(new HtmlTableRow(ipAddress,
                                generateMs()));
                    }
                }
            } else {
                System.err.println(WRONG_DATA_SOURCE);
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
     * Generate random number from 10 to 500.
     *
     * @return random response time in ms.
     */
    private static int generateMs() {
        Random random = new Random();
        int minMs = 9;
        return minMs + random.nextInt(492);
    }

    /**
     * Read file with ip addresses, and convert they to String array.
     *
     * @return String array with ip addresses.
     * @throws IOException for BufferedReader, it's may throw I/O exceptions.
     */
    private static String[] readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("IpAddresses.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println(FILE_READ_ERROR);
        } finally {
            bufferedReader.close();
        }
        String[] ipAddresses = stringBuilder.toString().split(System.lineSeparator());
        return ipAddresses;
    }

}
