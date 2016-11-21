package com.tat.at1.instructions;

import org.openqa.selenium.WebDriver;

/**
 * Created by Я on 19.11.2016.
 */
public class CheckPageContainsInstruction extends AbstractInstruction {
    public static final String NAME = "checkPageContains";

    public CheckPageContainsInstruction(String value, String id) {
        super(value, id);
    }

    @Override
    public boolean execute(WebDriver webDriver) {
        return webDriver.getPageSource().contains(this.getValue());
    }
}
