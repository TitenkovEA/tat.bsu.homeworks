package tat.bsu.homework.lesson3.task9;

import java.util.List;

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
                    "   <tr bgcolor = \"#CECFCE\" height=\"45\" align=\"center\" valign=\"top\"> \n" +
                    "     <th width=\"140\"><font size=\"4\" face=\"Arial\">ИМЯ</font></th> \n" +
                    "     <th width=\"140\"><font size=\"4\" face=\"Arial\">ТИП</font></th> \n" +
                    "     <th width=\"140\"><font size=\"4\" face=\"Arial\">ДАТА СОЗДАНИЯ</font></th> \n" +
                    "     <th width=\"140\"><font size=\"4\" face=\"Arial\">РАЗМЕР (в Kb)</font></th> \n" +
                    "   </tr> \n";
    private final static String HEAD_FIRST_TABLE_ROW =
            "   <tr bgcolor = \"#EFEFEF\"> \n";
    private final static String HEAD_SECOND_TABLE_ROW =
            "   <tr bgcolor = \"#F7F7F7\"> \n";
    private final static String HEAD_TABLE_CELL =
            "    <td> \n" +
                    "     <font size=\"4\" face=\"Arial\">";
    private final static String END_TABLE_CELL =
            "</font> \n" +
                    "    </td> \n";
    private final static String END_TABLE_ROW =
            "   </tr> \n";
    private final static String END_TABLE =
            "  </table> \n" +
                    " </body> \n" +
                    "</html>";

    /**
     * Creates an HTML table.
     *
     * @param htmlTableRowStorage - contains information about the files.
     * @return HTML table type of String.
     */
    public String buildHtmlTable(HtmlTableRowStorage htmlTableRowStorage) {
        StringBuilder htmlTable = new StringBuilder();
        List<FileInformation> files = htmlTableRowStorage.getFileStorage();

        htmlTable.append(HEAD_TABLE);
        for (int i = 0; i < files.size(); i++) {
            htmlTable.append((i % 2 == 0) ? HEAD_FIRST_TABLE_ROW : HEAD_SECOND_TABLE_ROW);
            htmlTable.append(HEAD_TABLE_CELL + files.get(i).getName() + END_TABLE_CELL +
                    HEAD_TABLE_CELL + files.get(i).getType() + END_TABLE_CELL +
                    HEAD_TABLE_CELL + files.get(i).getDate() + END_TABLE_CELL +
                    HEAD_TABLE_CELL + files.get(i).getSize() + END_TABLE_CELL +
                    END_TABLE_ROW);
        }
        htmlTable.append(END_TABLE);

        return htmlTable.toString();
    }
}
