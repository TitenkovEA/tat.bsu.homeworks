package com.tat.at1.instructions;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.SystemClock;

import java.security.PublicKey;
import java.util.List;

/**
 * Represents class of PageInstruction.
 * Can open url pages.
 * Contains instruction depends on this page.
 *
 * @author Eugeny Titenkov.
 */
public class PageInstruction {
    public static final String NAME = "open";

    private String url;
    private double timeout;
    private String id;
    private List<AbstractInstruction> instructions;

    /**
     * Create object of PageInstruction with received params.
     *
     * @param url          - page url address.
     * @param timeout      - timeout to open page.
     * @param id           - identifier of page.
     * @param instructions - instruction depends on this page.
     */
    public PageInstruction(String url, double timeout, String id,
                           List<AbstractInstruction> instructions) {
        this.url = url;
        this.timeout = timeout;
        this.id = id;
        this.instructions = instructions;
    }

    /**
     * Returns list of instruction depends on this page.
     *
     * @return list of instruction depends on this page.
     */
    public List<AbstractInstruction> getInstructions() {
        return instructions;
    }

    /**
     * Add instruction to list of instruction depends on this page.
     *
     * @param instruction - instruction to add.
     */
    public void addInstruction(AbstractInstruction instruction) {
        this.instructions.add(instruction);
    }

    /**
     * Returns id of page.
     *
     * @return id of page.
     */
    public String getId() {
        return id;
    }

    /**
     * Open url.
     *
     * @param webDriver - driver, where page must be opened.
     * @return true, if url was open in timeout, else false.
     */
    public boolean open(WebDriver webDriver) {
        long startTime;
        long finishTime;
        try {
            startTime = System.currentTimeMillis();
            webDriver.get(url);
            finishTime = System.currentTimeMillis();
        } catch (TimeoutException te) {
            return false;
        } catch (WebDriverException wde) {
            return false;
        }
        double elapsedTime = (double) (finishTime - startTime) / 1000;
        return elapsedTime < this.timeout;
    }

    /**
     * Returns information about this object.
     *
     * @return information about this object.
     */
    public String getInfoMessage() {
        return "[" +
                NAME +
                " " +
                url +
                " " +
                timeout +
                " " +
                id +
                "]";
    }
}
