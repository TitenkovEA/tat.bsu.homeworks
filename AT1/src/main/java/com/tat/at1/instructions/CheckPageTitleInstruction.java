package com.tat.at1.instructions;

import org.openqa.selenium.WebDriver;

/**
 * Represents class of CheckPageTitleInstruction instruction.
 *
 * @author Eugeny Titenkov.
 */
public class CheckPageTitleInstruction extends AbstractInstruction {
    public static final String NAME = "checkPageTitle";

    /**
     * Create object of instruction with received params.
     *
     * @param value  - value of instruction.
     * @param pageId - id of page, where instruction must be executed.
     */
    public CheckPageTitleInstruction(String value, String pageId) {
        super(value, pageId);
    }

    /**
     * Executes instruction.
     * Check page title exist by text.
     *
     * @param webDriver - driver, where instruction must be executed.
     * @return true, if execution pass with success, else false.
     */
    @Override
    public boolean execute(WebDriver webDriver) {
        return this.getValue().equals(webDriver.getTitle());
    }

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
