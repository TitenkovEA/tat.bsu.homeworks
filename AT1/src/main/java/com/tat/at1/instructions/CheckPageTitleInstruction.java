package com.tat.at1.instructions;

import org.openqa.selenium.WebDriver;

/**
 * Created by Я on 19.11.2016.
 */
public class CheckPageTitleInstruction extends AbstractInstruction {
    public static final String NAME = "checkPageTitle";

    public CheckPageTitleInstruction(String value, String id) {
        super(value, id);
    }

    @Override
    public boolean execute(WebDriver webDriver) {
        return this.getValue().equals(webDriver.getTitle());
    }
}
