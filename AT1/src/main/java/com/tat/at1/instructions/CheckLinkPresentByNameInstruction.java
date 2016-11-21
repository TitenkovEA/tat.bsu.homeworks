package com.tat.at1.instructions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Я on 19.11.2016.
 */
public class CheckLinkPresentByNameInstruction extends AbstractInstruction {
    public static final String NAME = "checkLinkPresentByName";

    public CheckLinkPresentByNameInstruction(String value, String id) {
        super(value, id);
    }

    @Override
    public boolean execute(WebDriver webDriver) {
        try {
            webDriver.findElement(By.name(this.getValue()));
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }
}
