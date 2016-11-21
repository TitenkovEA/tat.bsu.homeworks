package com.tat.at1.instructions;

import org.openqa.selenium.WebDriver;

/**
 * Created by Я on 19.11.2016.
 */
public abstract class AbstractInstruction {
    private String value;
    private String pageId;

    public AbstractInstruction(String value, String pageId) {
        this.value = value;
        this.pageId = pageId;
    }

    public String getValue() {
        return value;
    }

    public String getPageId() {
        return pageId;
    }

    public abstract boolean execute(WebDriver webDriver);
}
