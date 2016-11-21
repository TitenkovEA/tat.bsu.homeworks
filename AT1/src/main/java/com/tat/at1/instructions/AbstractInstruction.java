package com.tat.at1.instructions;

import org.openqa.selenium.WebDriver;

/**
 * Represents abstract class of instruction.
 *
 * @author Eugeny Titenkov.
 */
public abstract class AbstractInstruction {
    private String value;
    private String pageId;

    /**
     * Create object of instruction with received params.
     *
     * @param value  - value of instruction.
     * @param pageId - id of page, where instruction must be executed.
     */
    public AbstractInstruction(String value, String pageId) {
        this.value = value;
        this.pageId = pageId;
    }

    /**
     * Returns instruction value.
     *
     * @return instruction value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns instruction id of page, where instruction must be executed.
     *
     * @return instruction id of page, where instruction must be executed.
     */
    public String getPageId() {
        return pageId;
    }

    /**
     * Executes instruction.
     *
     * @param webDriver - driver, where instruction must be executed.
     * @return true, if execution pass with success, else false.
     */
    public abstract boolean execute(WebDriver webDriver);

    /**
     * Returns information about instruction.
     *
     * @return information about instruction.
     */
    public abstract String getInfoMessage();
}
