package tat.bsu.homework.lesson3.task10;

/**
 * Represents model of html table row,
 * supports the return of the prepared html table row.
 *
 * @author Eugeny Titenkov
 */
public class HtmlTableRow {
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
    private int ms;

    /**
     * Creates object of HtmlTableRow, gets input parameters of HtmlTableRow
     * and adds information about input types of HtmlTableRow.
     *
     * @param ipAddress - first parameter is IP address.
     * @param ms        - second parameter is response time in ms.
     */
    public HtmlTableRow(String ipAddress, int ms) {
        this.ipAddress = ipAddress;
        this.ms = ms;
    }

    /**
     * Return prepared html row, based on object of this class.
     *
     * @param constantColorFromHtmlTableRow - color of row.
     * @return prepared html row.
     */
    public String getHtmlTableRow(String constantColorFromHtmlTableRow) {
        StringBuilder row = new StringBuilder();
        row.append(HEAD_ROW + constantColorFromHtmlTableRow +
                HEAD_CELL + ipAddress + END_CELL +
                HEAD_CELL + ms + END_CELL +
                END_ROW);
        return row.toString();
    }

    /**
     * Return response time in ms.
     *
     * @return response time in ms.
     */
    public int getMs() {
        return ms;
    }
}
