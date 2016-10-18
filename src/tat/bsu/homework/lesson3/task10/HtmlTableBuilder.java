package tat.bsu.homework.lesson3.task10;

/**
 * Produces html table builder.
 *
 * @author Eugeny Titenkov
 */
public class HtmlTableBuilder {
    private final static String HEAD_TABLE =
            "<html> \n" +
                    " <head> \n" +
                    "  <meta charset=\"utf-8\"> \n" +
                    " </head> \n" +
                    " <body> \n" +
                    "  <table> \n" +
                    "   <tr bgcolor = \"#999999\" height=\"40\" align=\"center\"> \n" +
                    "     <th width=\"400\"><font size=\"4\" face=\"Arial\"><strong>Server</strong></font></th> \n" +
                    "     <th width=\"400\"><font size=\"4\" face=\"Arial\"><strong>Response, ms</strong></font></th> \n" +
                    "   </tr> \n";
    private final static String END_TABLE =
            "  </table> \n" +
                    " </body> \n" +
                    "</html>";

    /**
     * Creates html table.
     *
     * @param htmlTableRowStorage contains list of html table rows.
     * @return html table type of string.
     */
    public String buildHtmlTable(HtmlTableRowStorage htmlTableRowStorage) {
        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append(HEAD_TABLE);
        for (String tableRow : htmlTableRowStorage.getHtmlTableRows()) {
            htmlTable.append(tableRow);
        }
        htmlTable.append(END_TABLE);
        return htmlTable.toString();
    }
}
