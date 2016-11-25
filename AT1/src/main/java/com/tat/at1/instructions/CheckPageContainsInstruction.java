package com.tat.at1.instructions;

import org.openqa.selenium.WebDriver;

/**
 * Represents class of CheckPageContainsInstruction instruction.
 *
 * @author Eugeny Titenkov.
 */
public class CheckPageContainsInstruction extends AbstractInstruction {
    public static final String NAME = "checkPageContains";

    /**
     * Create object of instruction with received params.
     *
     * @param value  - value of instruction.
     * @param pageId - id of page, where instruction must be executed.
     */
    public CheckPageContainsInstruction(String value, String pageId) {
        super(value, pageId);
    }

    /**
     * Executes instruction.
     * Check page contains exist by text.
     *
     * @param webDriver - driver, where instruction must be executed.
     * @return true, if execution pass with success, else false.
     */
    @Override
    public boolean execute(WebDriver webDriver) {
        return webDriver.getPageSource().contains(this.getValue());
    }

    /**
     * Returns information about instruction.
     *
     * @return information about instruction.
     */
    @Override
    public String getInfoMessage() {
        return "[" +
                NAME +
                " " +
                this.getValue() +
                " " +
                this.getPageId() +
                "]";
    }
}
