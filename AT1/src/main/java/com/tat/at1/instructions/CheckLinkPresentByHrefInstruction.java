package com.tat.at1.instructions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Я on 19.11.2016.
 */
public class CheckLinkPresentByHrefInstruction extends AbstractInstruction {
    public static final String NAME = "checkLinkPresentByHref";

    public CheckLinkPresentByHrefInstruction(String value, String id) {
        super(value, id);
    }

    @Override
    public boolean execute(WebDriver webDriver) {
        try {
            webDriver.findElement(By.xpath("//link[@href='" + this.getValue() + "']"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
