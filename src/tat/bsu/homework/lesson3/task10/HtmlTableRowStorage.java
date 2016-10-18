package tat.bsu.homework.lesson3.task10;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains list of html table rows,
 * supports adding html table row to list,
 * and the return of the list with lines of html table row.
 *
 * @author Eugeny Titenkov
 */
public class HtmlTableRowStorage {
    private List<HtmlTableRow> htmlTableRows = new ArrayList<HtmlTableRow>();

    /**
     * Adding html table row to list.
     *
     * @param htmlTableRow - contains row info.
     * @return this.
     */
    public HtmlTableRowStorage addHtmlTableRow(HtmlTableRow htmlTableRow) {
        htmlTableRows.add(htmlTableRow);
        return this;
    }

    /**
     * Return a list with prepared strings of html table row.
     *
     * @return list, which contains prepared strings of html table row.
     */
    public List<String> getHtmlTableRows() {
        List<String> htmlRows = new ArrayList<String>();
        int maxMs = getMaxMS();
        boolean switchColor = true;
        for (HtmlTableRow htmlTableRow : htmlTableRows) {
            if (htmlTableRow.getMs() == maxMs) {
                htmlRows.add(htmlTableRow.getHtmlTableRow(HtmlTableRow.RED_ROW_COLOR));
            } else {
                if (switchColor) {
                    htmlRows.add(htmlTableRow.getHtmlTableRow(HtmlTableRow.FIRST_GREY_ROW_COLOR));
                    switchColor = false;
                } else {
                    htmlRows.add(htmlTableRow.getHtmlTableRow(HtmlTableRow.SECOND_GREY_ROW_COLOR));
                    switchColor = true;
                }
            }
        }
        return htmlRows;
    }

    /**
     * Return max value of ms from htmlTableRows.
     *
     * @return max value of ms.
     */
    private int getMaxMS() {
        int maxMs = 0;
        for (HtmlTableRow htmlTableRow : htmlTableRows) {
            if (htmlTableRow.getMs() > maxMs) {
                maxMs = htmlTableRow.getMs();
            }
        }
        return maxMs;
    }
}
