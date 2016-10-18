package tat.bsu.homework.lesson3.task10;

import java.util.Random;

/**
 * Represents model of html table row,
 * supports the return of the prepared html table row.
 *
 * @author Eugeny Titenkov
 */
public class HtmlServerEntryRow {
    private final static String HEAD_ROW = "<tr align=\"left\" height=\"40\"";
    public final static String FIRST_GREY_ROW_COLOR = " bgcolor = \"#EFEFEF\"> \n";
    public final static String SECOND_GREY_ROW_COLOR = " bgcolor = \"#D9D9D9\"> \n";
    public final static String RED_ROW_COLOR = " bgcolor = \"#FF0000\"> \n";
    private final static String HEAD_CELL = "<td> \n" +
            " <font size=\"4\" face=\"Arial\"> ";
    private final static String END_CELL = " </font> \n" +
            "</td> \n";
    private final static String END_ROW = "</rw> \n";
    private String ipAddress;
    private int responseTime;

    /**
     * Creates object of HtmlTableRow, gets input parameters of HtmlTableRow
     * and adds information about input types of HtmlTableRow.
     *
     * @param ipAddress - first parameter is IP address.
     */
    public HtmlServerEntryRow(String ipAddress) {
        this.ipAddress = ipAddress;
        this.responseTime = generateResponseTime();
    }

    /**
     * Return prepared html row, based on object of this class.
     *
     * @param constantColorFromHtmlTableRow - color of row.
     * @return prepared html row.
     */
    public String getHtmlServerEntryRow(String constantColorFromHtmlTableRow) {
        return HEAD_ROW + constantColorFromHtmlTableRow +
                HEAD_CELL + ipAddress + END_CELL +
                HEAD_CELL + responseTime + END_CELL +
                END_ROW;
    }

    /**
     * Return response time in responseTime.
     *
     * @return response time in responseTime.
     */
    public int getResponseTime() {
        return responseTime;
    }

    /**
     * Generate random number from 10 to 500.
     *
     * @return random response time in ms.
     */
    private int generateResponseTime() {
        Random random = new Random();
        int minMs = 9;
        return minMs + random.nextInt(492);
    }
}
