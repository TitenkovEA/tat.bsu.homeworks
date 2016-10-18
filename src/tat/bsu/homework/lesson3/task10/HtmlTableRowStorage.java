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
    private List<HtmlServerEntryRow> htmlServerEntryRows = new ArrayList<HtmlServerEntryRow>();

    /**
     * Adding html table row to list.
     *
     * @param htmlServerEntryRow - contains row info.
     * @return this.
     */
    public HtmlTableRowStorage addHtmlTableRow(HtmlServerEntryRow htmlServerEntryRow) {
        htmlServerEntryRows.add(htmlServerEntryRow);
        return this;
    }

    /**
     * Return a list with prepared strings of html table row.
     *
     * @return list, which contains prepared strings of html table row.
     */
    public List<String> getHtmlServerEntryRows() {
        List<String> htmlRows = new ArrayList<String>();
        int maxMs = getMaxMS();
        boolean switchColor = true;
        for (HtmlServerEntryRow htmlServerEntryRow : htmlServerEntryRows) {
            if (htmlServerEntryRow.getResponseTime() == maxMs) {
                htmlRows.add(htmlServerEntryRow.getHtmlServerEntryRow(
                        HtmlServerEntryRow.RED_ROW_COLOR));
            } else {
                htmlRows.add(htmlServerEntryRow.getHtmlServerEntryRow(
                        switchColor ? HtmlServerEntryRow.FIRST_GREY_ROW_COLOR :
                                      HtmlServerEntryRow.SECOND_GREY_ROW_COLOR));
                switchColor = !switchColor;
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
        for (HtmlServerEntryRow htmlServerEntryRow : htmlServerEntryRows) {
            if (htmlServerEntryRow.getResponseTime() > maxMs) {
                maxMs = htmlServerEntryRow.getResponseTime();
            }
        }
        return maxMs;
    }
}
