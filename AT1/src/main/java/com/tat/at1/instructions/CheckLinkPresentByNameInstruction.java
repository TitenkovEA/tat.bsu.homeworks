package com.tat.at1.instructions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Represents class of CheckLinkPresentByNameInstruction instruction.
 *
 * @author Eugeny Titenkov.
 */
public class CheckLinkPresentByNameInstruction extends AbstractInstruction {
    public static final String NAME = "checkLinkPresentByName";

    /**
     * Create object of instruction with received params.
     *
     * @param value  - value of instruction.
     * @param pageId - id of page, where instruction must be executed.
     */
    public CheckLinkPresentByNameInstruction(String value, String pageId) {
        super(value, pageId);
    }

    /**
     * Executes instruction.
     * Check link exist by name of link.
     *
     * @param webDriver - driver, where instruction must be executed.
     * @return true, if execution pass with success, else false.
     */
    @Override
    public boolean execute(WebDriver webDriver) {
        try {
            webDriver.findElement(By.name(this.getValue()));
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
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
